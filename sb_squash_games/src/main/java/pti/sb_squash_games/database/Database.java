package pti.sb_squash_games.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import pti.sb_squash_games.database.entities.Game;
import pti.sb_squash_games.database.entities.Location;
import pti.sb_squash_games.database.entities.User;

public class Database {
	
	private SessionFactory factory;
	
	public Database() {
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
	}
	
	public void addUser(User user) throws NullPointerException {
		
		if (user != null) {
			
			Session session = factory.openSession();
			session.beginTransaction();
			
			session.save(user);
			
			session.getTransaction().commit();
			session.close();
			
		} else {
			throw new NullPointerException("User is null!");
		}
		
	}
	
	public void addLocation(Location location) throws NullPointerException {
		
		if (location != null) {
			
			Session session = factory.openSession();
			session.beginTransaction();
			
			session.save(location);
			
			session.getTransaction().commit();
			session.close();
			
		} else {
			throw new NullPointerException("Location is null");
		}
		
	}
	
	public void addGame(Game game) throws NullPointerException {
		
		if (game != null) {
			
			Session session = factory.openSession();
			session.beginTransaction();
			
			session.save(game);
			
			session.getTransaction().commit();
			session.close();
			
		} else {
			throw new NullPointerException("Game is null!");
		}
		
	}
	
	public void close() {
		factory.close();
	}
}
