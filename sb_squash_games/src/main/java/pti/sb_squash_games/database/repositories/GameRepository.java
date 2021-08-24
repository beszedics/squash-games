package pti.sb_squash_games.database.repositories;

import org.springframework.data.repository.CrudRepository;

import pti.sb_squash_games.database.entities.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {

}
