package pti.sb_squash_games.database.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pti.sb_squash_games.database.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	List<User> findByNameAndPassword(String username, String password);
	List<User> findByName(String username);
	
}
