package pl.mmorpg.prototype.data.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.mmorpg.prototype.data.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>
{
	Optional<User> findByUsername(String username);
}
