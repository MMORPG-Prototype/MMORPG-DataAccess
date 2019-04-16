package pl.mmorpg.prototype.data.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.mmorpg.prototype.data.entities.components.keys.CharactersQuestsKey;
import pl.mmorpg.prototype.data.entities.jointables.CharactersQuests;

public interface CharactersQuestsRepository extends CrudRepository<CharactersQuests, CharactersQuestsKey>
{

}
