package mzebrowski.database.DAOs;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import mzebrowski.database.domain.Expense;
import mzebrowski.database.domain.PurchaseType;
import mzebrowski.database.domain.User;

public class DatabaseAccessObject {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ec_db_configuration");
		//^ s³u¿y do wykonywania zapytañ z baz¹ danych
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
//		User user = new User();
//		user.setUserName("Marta");
//		user.setPassword("password");
//		user.setAccount_balance(10);
//		user.setData(new Date());
//		user.setLastPurchaseType(PurchaseType.FOOD);		
//		
//		User user2 = new User();
//		user2.setUserName("Iza");
//		user2.setPassword("passwor2");
//		user2.setAccount_balance(10);
//		user2.setData(new Date());
//		user2.setLastPurchaseType(PurchaseType.ITEM);	
		
		
//		// wrzucanie obiektu od bazy danych - nale¿y zacz¹æ i zakoñczyæ tranzakcjê
//		entityManager.getTransaction().begin();
//		entityManager.persist(user);
//		entityManager.persist(user2);
//
//		entityManager.getTransaction().commit();
//		
//		Expense exp1 = new Expense();
//		exp1.setAmount(100.12);
//		exp1.setDate(new Date());
//		exp1.setName("a1");
//		exp1.setUserId(user);
//		
//		Expense exp2 = new Expense();
//		exp2.setAmount(100.12);
//		exp2.setDate(new Date());
//		exp2.setName("a2");
//		exp2.setUserId(user);
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(exp1);
//		entityManager.persist(exp2);
//		entityManager.getTransaction().commit();
		
		
		//TypedQuery<User> query = entityManager.createQuery("select u from User u where u.", User.class);
		//ser user3 = query.getSingleResult();		
		//query.getResultList();
		//System.out.println(user3.getUserName() + user3.getPassword());
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
