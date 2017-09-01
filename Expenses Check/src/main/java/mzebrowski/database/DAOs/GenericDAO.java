package mzebrowski.database.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class GenericDAO<T> {

	public abstract List<T> getAll();
	public abstract List<String> getAllNames();
	
	//Protected
    protected final String tableName;
    EntityManager entityManager;
    
    protected GenericDAO(EntityManager entityManager, String tableName) {
        this.tableName = tableName;
        this.entityManager = entityManager;
    }
    
    
    
}
