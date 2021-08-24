package pti.sb_squash_games.database.repositories;

import org.springframework.data.repository.CrudRepository;

import pti.sb_squash_games.database.entities.User;

public interface IUserRepository extends CrudRepository<User, Integer> {

}
