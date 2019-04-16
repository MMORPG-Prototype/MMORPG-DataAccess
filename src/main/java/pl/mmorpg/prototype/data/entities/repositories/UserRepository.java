package pl.mmorpg.prototype.data.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.mmorpg.prototype.data.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>
{
	User findByUsername(String username);
}
