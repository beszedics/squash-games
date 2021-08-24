package pti.sb_squash_games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_squash_games.database.entities.User;
import pti.sb_squash_games.database.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean isUserExits(String username, String password) throws NullPointerException {
		
		boolean isExists = false;
		
		List<User> user = userRepository.findByNameAndPassword(username, password);
		
		if (user != null) {
			
			if (!user.isEmpty()) {
				isExists = true;
			}
			
		} else {
			throw new NullPointerException();
		}
		
		return isExists;
	}
}
