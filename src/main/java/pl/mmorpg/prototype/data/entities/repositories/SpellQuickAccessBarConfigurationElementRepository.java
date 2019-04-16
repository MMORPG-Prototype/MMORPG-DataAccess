package pl.mmorpg.prototype.data.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.mmorpg.prototype.data.entities.SpellQuickAccessBarConfigurationElement;
import pl.mmorpg.prototype.data.entities.Character;

public interface SpellQuickAccessBarConfigurationElementRepository
		extends CrudRepository<SpellQuickAccessBarConfigurationElement, Integer>
{
	List<SpellQuickAccessBarConfigurationElement> findByCharacter(Character character);
}
