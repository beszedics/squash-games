package pti.sb_squash_games.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_squash_games.database.entities.Location;
import pti.sb_squash_games.database.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	public void addLocation(Location location) {
		
		try {
			locationRepository.save(location);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}	
	}
}
