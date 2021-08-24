package pti.sb_squash_games.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_squash_games.database.entities.User;
import pti.sb_squash_games.database.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserIfExits(String username, String password) throws NullPointerException {
		
		User user = null;
		
		List<User> actualUser = userRepository.findByNameAndPassword(username, password);
		
		if (actualUser != null) {
			
			if (!actualUser.isEmpty()) {
				
				user = actualUser.get(0);
				
			}
			
		} else {
			throw new NullPointerException();
		}
		
		return user;
	}
	
	public boolean isAdmin(User user) {
		
		boolean isAdmin = false;
		
		if (user != null) {
			Integer userId = user.getId();
			
			Optional<User> actualUser = userRepository.findById(userId);
			
			if (actualUser.isPresent()) {
				
				if (actualUser.get().getIsAdmin()) {
					isAdmin = true;
				}
				
			} else {
				throw new NullPointerException();
			}
			
		} else {
			throw new NullPointerException();
		}
		
		return isAdmin;
	}
}
