package pti.sb_squash_games.database.repositories;

import org.springframework.data.repository.CrudRepository;

import pti.sb_squash_games.database.entities.Result;

public interface IResultRepository extends CrudRepository<Result, Integer> {

}
