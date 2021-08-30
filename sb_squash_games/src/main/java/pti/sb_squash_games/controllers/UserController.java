package pti.sb_squash_games.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pti.sb_squash_games.database.entities.Game;
import pti.sb_squash_games.database.entities.Location;
import pti.sb_squash_games.database.entities.User;
import pti.sb_squash_games.services.GameService;
import pti.sb_squash_games.services.LocationService;
import pti.sb_squash_games.services.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GameService gameService; 
	
	@Autowired
	private LocationService locationService;
	
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(
			@RequestParam String username,
			@RequestParam String password
	) {
		
		String page = "login";
		
		User user = userService.getUserIfExits(username, password);
		
		if (user != null) {
			
			if (!user.getIsAdmin()) {
				
				if (!user.getIsPasswordChanged()) {
					
					page = "user.updatepassword";
				
				} else {
					page = "index";
				}
			}
		}
		
		return page;
	}
	
	@PostMapping(value = "/updatePassword")
	public String updatePassword(
			@RequestParam String username,
			@RequestParam String password
	) {
		
		User user = userService.getUserByName(username);
		
		user.setPassword(password);
		user.setIsPasswordChanged(true);
		
		userService.addUser(user);
		
		return "index";
	}
	
	@GetMapping(value = "/games")
	public String getAllGames(Model model) {
		
		List<Game> games = gameService.getAllGames();
		
		Collections.sort(games, Comparator.comparing(Game::getDate).reversed());
		
		model.addAttribute("games", games);
		
		return "index";
	}
	
	@GetMapping(value = "/locations")
	public String getAllLocations(Model model) {
		
		List<Location> locations = locationService.getAllLocations();
		
		model.addAttribute("locations", locations);
		
		return "index";
	}
	
	@PostMapping(value = "/filteredName")
	public String getFilteredName(Model model, @RequestParam String filterName) {
		
		List<Game> games = new ArrayList<Game>();
		
		List<Game> gamesList = gameService.getAllGames();
		
		for (Game game : gamesList) {
			
			String firstUserName = game.getResult().getFirstUser().getName();
			String secondUserName = game.getResult().getSecondUser().getName();
			
			/** If one of username equals with parameter name, add the given row to the list  */
			if (firstUserName.equals(filterName) || secondUserName.equals(filterName)) {
				games.add(game);
			}
		}
		
		Collections.sort(games, Comparator.comparing(Game::getDate).reversed());
		
		model.addAttribute("games", games);
		
		return "index";
	}
	
	@PostMapping(value = "/filteredLocation")
	public String getFilteredLocationName(Model model, @RequestParam String filteredLocationName) {
		
		List<Game> games = new ArrayList<Game>();
		
		List<Game> gamesList = gameService.getAllGames();
		
		for (Game game : gamesList) {
			
			String locationName = game.getLocation().getName();
			
			if (locationName.equals(filteredLocationName)) {
				games.add(game);
			}
		}
		
		Collections.sort(games, Comparator.comparing(Game::getDate).reversed());
		
		model.addAttribute("games", games);
		
		return "index";
	}
}
