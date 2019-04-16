package pl.mmorpg.prototype.data.entities.jointables;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.mmorpg.prototype.data.entities.Character;
import pl.mmorpg.prototype.data.entities.*;
import pl.mmorpg.prototype.data.entities.components.EntityQuestTask;
import pl.mmorpg.prototype.data.entities.components.keys.CharactersQuestsKey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

@Entity(name = "CharactersQuests")
@Table(name = "characters_quests")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "key")
public class CharactersQuests
{
    @EmbeddedId
    private CharactersQuestsKey key = new CharactersQuestsKey();

    @OneToMany(mappedBy = "charactersQuests", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<QuestTaskWrapper> questTasks = new LinkedList<>();

    @OneToMany(mappedBy = "charactersQuests", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<CharactersQuestsItemReward> itemsReward = new ArrayList<>();

    @Column(name = "gold_reward", nullable = false)
    private Integer goldReward;

	/**
	 * Going from source task this column contains position index in parent.nextTasks collection
	 * indexes of quest tasks finished. Null if no task was finished yet
	 * For eg. 0,2 means that first task was on index 0, second was on index 2 in children
	 * collection tasks of first one. Both tasks are finished.
	 */
	@Column(name = "finished_quest_tasks_path")
	private String finishedQuestTasksPath;

    public CharactersQuests(Character character, Quest quest)
    {
        setCharacter(character);
        setQuest(quest);
        initializeItemsReward(quest.getItemsReward());
        goldReward = quest.getGoldReward();
        Collection<EntityQuestTask> nextTasks = quest.getQuestTask().getNextEntityTasks();
        setFinishedQuestTasksPath("0");
        initializeCurrentQuestTasks(nextTasks);
    }

    private void initializeItemsReward(Collection<QuestItemReward> itemsReward)
    {
        Collection<CharactersQuestsItemReward> convertedItemsReward = itemsReward.stream()
                .map(item -> new CharactersQuestsItemReward(item.getItemIdentifier(), item.getNumberOfItems(), this))
                .collect(Collectors.toList());
        this.itemsReward.addAll(convertedItemsReward);
    }

    private void initializeCurrentQuestTasks(Collection<EntityQuestTask> nextTasks)
    {
        nextTasks.forEach(task ->
        {
            QuestTaskWrapper questTaskWrapper = new QuestTaskWrapper();
            questTaskWrapper.setCharactersQuests(this);
            questTaskWrapper.setQuestTask(task);
            task.setSourceTask(this);
            this.questTasks.add(questTaskWrapper);
        });
    }

    @Transient
    public Character getCharacter()
    {
        return key.getCharacter();
    }

    public void setCharacter(Character character)
    {
        key.setCharacter(character);
    }

    @Transient
    public Quest getQuest()
    {
        return key.getQuest();
    }

    public void setQuest(Quest quest)
    {
        key.setQuest(quest);
    }

	public String getFinishedQuestTasksPath()
	{
		return finishedQuestTasksPath;
	}

	public void setFinishedQuestTasksPath(String finishedQuestTasksPath)
	{
		this.finishedQuestTasksPath = finishedQuestTasksPath;
	}

}
