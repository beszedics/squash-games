package pti.sb_squash_games.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pti.sb_squash_games.database.entities.User;
import pti.sb_squash_games.services.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
			page = "index";
		}
		
		return page;
	}
}
