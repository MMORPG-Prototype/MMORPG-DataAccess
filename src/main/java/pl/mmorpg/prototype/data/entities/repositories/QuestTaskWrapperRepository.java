package pl.mmorpg.prototype.data.entities.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import pl.mmorpg.prototype.data.entities.QuestTaskWrapper;
import pl.mmorpg.prototype.data.entities.jointables.CharactersQuests;

public interface QuestTaskWrapperRepository extends CrudRepository<QuestTaskWrapper, Integer>
{
    Collection<QuestTaskWrapper> findByCharactersQuests(Collection<CharactersQuests> quests);
}
