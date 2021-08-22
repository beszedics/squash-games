package pti.sb_squash_games.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Database {
	
	private SessionFactory factory;
	
	public Database() {
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
	}
	
	public void close() {
		factory.close();
	}

}
