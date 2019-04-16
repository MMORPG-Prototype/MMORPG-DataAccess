package pl.mmorpg.prototype.data.entities.components.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import pl.mmorpg.prototype.data.entities.components.EntityQuestTask;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestTaskKey implements Serializable
{
    private CharactersQuestsKey key = new CharactersQuestsKey();
    
    @Type(type = "pl.mmorpg.prototype.data.jsonconfig.EntityQuestTaskJsonUserType")
    @Column(name="quest_task", nullable = false, length = 10000)
    private EntityQuestTask questTask;
}
