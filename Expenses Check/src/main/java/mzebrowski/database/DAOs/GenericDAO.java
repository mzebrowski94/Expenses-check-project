package mzebrowski.database.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import mzebrowski.database.domain.enums.E_TableType;

public abstract class GenericDAO<T> {

	public abstract List<T> getAll();
	public abstract List<String> getAllNames();
	
	//Protected
    protected final String tableName;
    EntityManager entityManager;
    CriteriaBuilder criteriaBuilder;
    
    protected GenericDAO(EntityManager entityManager,CriteriaBuilder criteriaBuilder, E_TableType tableType) {
        this.tableName = tableType.toString();
        this.entityManager = entityManager;
    }

	public List<Object> getValueWithID(int id, String attributeName) {
		Query query = entityManager.createQuery("t.:attribute from :tableName t", Object.class);
		query.setParameter("tableName", tableName);
		query.setParameter("id", id);
		query.setParameter("attribute", attributeName);
		
		return query.getResultList();
	}
    
	public static <T> T getSingleResult(TypedQuery<T> query) {
	    query.setMaxResults(1);
	    List<T> list = query.getResultList();
	    if (list == null || list.isEmpty()) {
	        return null;
	    }

	    return list.get(0);
	}
}
