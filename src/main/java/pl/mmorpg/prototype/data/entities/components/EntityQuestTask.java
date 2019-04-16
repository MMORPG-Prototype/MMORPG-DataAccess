package pl.mmorpg.prototype.data.entities.components;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pl.mmorpg.prototype.data.entities.jointables.CharactersQuests;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public interface EntityQuestTask
{
	void setSourceTask(CharactersQuests sourceTask);

	@JsonIgnore
	List<EntityQuestTask> getNextEntityTasks();
}
