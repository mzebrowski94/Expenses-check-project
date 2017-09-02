package mzebrowski.database.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mzebrowski.database.domain.user.User;



public class FindAndModify {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ec_db_configuration");
		//^ s�u�y do wykonywania zapyta� z baz� danych
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		User tempUser = entityManager.find(User.class, 1);
		System.out.println(tempUser.getUserName());

		tempUser.setPassword("makaron");
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
