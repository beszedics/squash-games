package pti.sb_squash_games.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pti.sb_squash_games.database.entities.Game;
import pti.sb_squash_games.database.entities.User;
import pti.sb_squash_games.services.GameService;
import pti.sb_squash_games.services.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GameService gameService; 
	
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
		
		model.addAttribute("games", games);
		
		return "index";
	}
}
