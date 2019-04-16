package pl.mmorpg.prototype.data.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.mmorpg.prototype.data.entities.CharacterItem;
import pl.mmorpg.prototype.data.entities.Character;

public interface CharacterItemRepository extends CrudRepository<CharacterItem, Integer>
{
	List<CharacterItem> findByCharacter(Character character);
	
	List<CharacterItem> findByCharacter_Id(Integer id);
}
