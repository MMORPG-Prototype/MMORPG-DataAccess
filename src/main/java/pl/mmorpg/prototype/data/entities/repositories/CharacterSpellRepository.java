package pl.mmorpg.prototype.data.entities.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import pl.mmorpg.prototype.clientservercommon.packets.SpellIdentifiers;
import pl.mmorpg.prototype.data.entities.CharacterSpell;

public interface CharacterSpellRepository extends CrudRepository<CharacterSpell, Integer>
{
	@Cacheable("spell")
	Iterable<CharacterSpell> findAll();
	
	@Cacheable("spell")
	CharacterSpell findByIdentifier(SpellIdentifiers identifier);
	
	// Collection<Spell> findByCharacters(Character character);
}
