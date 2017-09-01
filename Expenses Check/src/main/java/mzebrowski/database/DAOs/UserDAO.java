package mzebrowski.database.DAOs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import mzebrowski.database.domain.User;

public class UserDAO extends GenericDAO<User> {

	public UserDAO(EntityManager entityManager, String tableName) {
		super(entityManager, tableName);
	}

	@Override
	public List<User> getAll() {
		return entityManager.createQuery("from User", User.class).getResultList();
	}

	@Override
	public List<String> getAllNames() {
		return entityManager.createQuery("select u.userName from User u", String.class).getResultList();
	}

}
