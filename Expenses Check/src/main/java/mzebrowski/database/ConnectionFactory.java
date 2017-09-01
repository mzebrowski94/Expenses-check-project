package mzebrowski.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	
	public EntityManager openDefaultConnection()
	{
		entityManager = openOnlineConnection();
		if(entityManager!=null)
			return entityManager;
		else
			return openOfflineConnection();
	}
	
	public EntityManager openOnlineConnection()
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("db_mysql_server_configuration");
		System.out.println("Opening online connection");
		return entityManagerFactory.createEntityManager();	
	}
	
	public EntityManager openOfflineConnection()
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("db_h2_filesystem_configuration");
		System.out.println("Opening online connection");
		return entityManagerFactory.createEntityManager();	
	}
}
