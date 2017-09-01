package mzebrowski.database;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import mzebrowski.database.DAOs.ExpenseDAO;
import mzebrowski.database.DAOs.UserDAO;
import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.Expense;
import mzebrowski.database.domain.User;

public class DAOManager {
	
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private ExpenseDAO expenseDAO;
	private UserDAO userDAO;
	
	public DAOManager(EntityManager entityManager) {
		this.entityManager= entityManager;
		this.entityManagerFactory = entityManager.getEntityManagerFactory();
		this.expenseDAO = new ExpenseDAO(entityManager, "Expenses Table");
		this.userDAO = new UserDAO(entityManager, "Users Table");
		
		//addSomeRandomData();
	}
	
	private void addSomeRandomData() {
		User user = new User();
		user.setUserName("Marta");
		user.setPassword("password");
		user.setAccountBalance(100);
		user.setData(new Date());
		
		User user2 = new User();
		user2.setUserName("Krzysiek");
		user2.setPassword("passwor2");
		user2.setAccountBalance(1000);
		user2.setData(new Date());

		User user3 = new User();
		user3.setUserName("Bartek");
		user3.setPassword("passwor2");
		user3.setAccountBalance(10);
		user3.setData(new Date());
		
//		// wrzucanie obiektu od bazy danych - nale¿y zacz¹æ i zakoñczyæ tranzakcjê
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.persist(user2);
		entityManager.persist(user3);
		entityManager.getTransaction().commit();
		
		Expense exp1 = new Expense();
		exp1.setAmount(123);
		exp1.setDate(new Date());
		exp1.setName("Jedzenie");
		exp1.setUserId(user);
		exp1.setPurchaseType(E_PurchaseType.BILLS);
		
		Expense exp2 = new Expense();
		exp2.setAmount(444);
		exp2.setDate(new Date());
		exp2.setName("a2");
		exp2.setUserId(user);
		exp2.setPurchaseType(E_PurchaseType.OTHER);
		
		Expense exp3 = new Expense();
		exp3.setAmount(143.12);
		exp3.setDate(new Date());
		exp3.setName("a1");
		exp3.setUserId(user2);
		exp3.setPurchaseType(E_PurchaseType.TICKET);
		
		Expense exp4 = new Expense();
		exp4.setAmount(100.55);
		exp4.setDate(new Date());
		exp4.setName("a2");
		exp4.setUserId(user2);
		exp3.setPurchaseType(E_PurchaseType.SHOPPING);
		
		Expense exp5 = new Expense();
		exp5.setAmount(100.12);
		exp5.setDate(new Date());
		exp5.setName("a1");
		exp5.setUserId(user3);
		exp5.setPurchaseType(E_PurchaseType.OTHER);
		
		entityManager.getTransaction().begin();
		entityManager.persist(exp1);
		entityManager.persist(exp2);
		entityManager.persist(exp3);
		entityManager.persist(exp4);
		entityManager.persist(exp5);
		entityManager.getTransaction().commit();
		
	}

	public void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}

	public ExpenseDAO getExpenseDAO() {
		return expenseDAO;
	}

	public void setExpenseDAO(ExpenseDAO expenseDAO) {
		this.expenseDAO = expenseDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
}




//public GenericDAO getDAO(E_Table tableType) throws SQLException 
//{
//  switch(tableType)
//  {
//  case EXPENSE:
//      return new ExpenseDAO(entityManager, "Expenses Table");
//  case USER:
//      return new UserDAO(entityManager, "Users Table");
//  default:
//      throw new SQLException("Trying to link to an unexistant table.");
//  }
//}
