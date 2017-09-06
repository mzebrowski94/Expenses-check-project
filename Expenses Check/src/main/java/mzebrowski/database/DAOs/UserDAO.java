package mzebrowski.database.DAOs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import mzebrowski.database.domain.E_TableType;
import mzebrowski.database.domain.user.User;

public class UserDAO extends GenericDAO<User> {

	public UserDAO(EntityManager entityManager,CriteriaBuilder criteriaBuilder, E_TableType tableType) {
		super(entityManager,criteriaBuilder, tableType);
	}

	@Override
	public List<User> getAll() {
		return entityManager.createQuery("from User", User.class).getResultList();
	}

	@Override
	public List<String> getAllNames() {
		return entityManager.createQuery("select u.userName from User u", String.class).getResultList();
	}

	public User getUser(String userName) {
		
			TypedQuery<User> query = entityManager.createQuery("from User u where u.userName = :userName", User.class);				
			query.setParameter("userName", userName);
			return getSingleResult(query);
	}

}
