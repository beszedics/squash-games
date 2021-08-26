package pti.sb_squash_games.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_squash_games.database.entities.Game;
import pti.sb_squash_games.database.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<Game> getAllGames() {
		
		Iterable<Game> iterableGames = gameRepository.findAll();
		
		List<Game> games = new ArrayList<Game>();
		
		for (Game game : iterableGames) {
			games.add(game);
		}
		
		return games;
	}
}
