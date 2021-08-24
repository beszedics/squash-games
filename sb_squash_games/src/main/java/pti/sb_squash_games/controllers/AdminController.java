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
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/login")
	public String login() {
		return "admin.login";
	}
	
	@PostMapping(value = "/login")
	public String login(
			@RequestParam String username,
			@RequestParam String password
	) {
		
		String page = "admin.login";
		
		User user = userService.getUserIfExits(username, password);
		
		if (user != null) {
			
			if (user.getIsAdmin()) {
				
				page = "admin.index";
				
			}
		}
		
		return page;	
	}
	
	@PostMapping(value = "/addUser")
	public String addUser(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam Boolean isAdmin
	) {
		
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		user.setIsAdmin(isAdmin);
		user.setIsPasswordChanged(false);
		
		userService.addUser(user);
	
		return "admin.index";
	}
}
