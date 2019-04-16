package pl.mmorpg.prototype.data.entities;

import lombok.Data;
import org.hibernate.annotations.Type;
import pl.mmorpg.prototype.data.entities.components.EntityQuestTask;
import pl.mmorpg.prototype.data.entities.jointables.CharactersQuests;

import javax.persistence.*;

@Entity(name = "QuestTask")
@Table(name = "quest_tasks")
@Data
public class QuestTaskWrapper
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Type(type = "pl.mmorpg.prototype.data.jsonconfig.EntityQuestTaskJsonUserType")
    @Column(name = "quest_task", nullable = true, length = 10000)
    private EntityQuestTask questTask;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "character_id", referencedColumnName = "character_id"),
            @JoinColumn(name = "quest_id", referencedColumnName = "quest_id")
            })
    private CharactersQuests charactersQuests;

    @PostLoad
    public void init()
    {
        questTask.setSourceTask(charactersQuests);
    }

    public void setQuestTask(EntityQuestTask questTask)
    {
        questTask.setSourceTask(charactersQuests);
        this.questTask = questTask;
    }

}
