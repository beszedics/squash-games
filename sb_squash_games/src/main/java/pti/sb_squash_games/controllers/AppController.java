package pti.sb_squash_games.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping(value = "/")
	public String index() {
		
		return "index";
		
	}
}
