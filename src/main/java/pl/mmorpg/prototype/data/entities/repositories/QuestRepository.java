package pl.mmorpg.prototype.data.entities.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import pl.mmorpg.prototype.data.entities.Quest;

public interface QuestRepository extends CrudRepository<Quest, Integer>
{
    Quest findByName(String questName);
    
    @Transactional
    default Quest findByNameFetchItemsReward(String questName)
    {
        Quest quest = findByName(questName);
        quest.getItemsReward().size();
        return quest;
    }
    
    @Transactional
    default Iterable<Quest> findAllFetchItemReward()
    {
    	Iterable<Quest> allQuests = findAll();
    	allQuests.forEach(q -> q.getItemsReward().size());
    	return allQuests;
    }
}
