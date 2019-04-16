package pl.mmorpg.prototype.data.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.mmorpg.prototype.data.entities.ItemQuickAccessBarConfigurationElement;
import pl.mmorpg.prototype.data.entities.Character;

public interface ItemQuickAccessBarConfigurationElementRepository
		extends CrudRepository<ItemQuickAccessBarConfigurationElement, Integer>
{
	List<ItemQuickAccessBarConfigurationElement> findByCharacter(Character character);
}
