package mzebrowski.database;

import java.sql.SQLException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import mzebrowski.database.DAOs.ExpenseDAO;
import mzebrowski.database.DAOs.GenericDAO;
import mzebrowski.database.DAOs.UserDAO;
import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.E_TableType;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.database.domain.user.User;

public class DAOManager {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;

	public DAOManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.entityManagerFactory = entityManager.getEntityManagerFactory();
		addSomeRandomDataFOR_PREVIEW_ONLY();
	}

	public GenericDAO getDAO(E_TableType tableType) throws SQLException {

		switch (tableType) {
		case EXPENSE:
			return new ExpenseDAO(entityManager, E_TableType.EXPENSE);
		case USER:
			return new UserDAO(entityManager, E_TableType.USER);
		default:
			throw new SQLException("Trying to link to an unexistant table.");
		}
	}

	public void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}

	private void addSomeRandomDataFOR_PREVIEW_ONLY() {
		User adam = addSomeUserFOR_PREVIEW_ONLY("Adam","password",100);
		User eva = addSomeUserFOR_PREVIEW_ONLY("Eva","password",40.10);
		User joseph = addSomeUserFOR_PREVIEW_ONLY("Joseph","password",34.77);
		User mathew = addSomeUserFOR_PREVIEW_ONLY("Mathew","password",77);
		
		addSomeExpenseFOR_PREVIEW_ONLY(40, "Food for breakfast", adam, E_PurchaseType.SHOPPING);
		addSomeExpenseFOR_PREVIEW_ONLY(6, "Bus ticket", eva, E_PurchaseType.TICKET);
		addSomeExpenseFOR_PREVIEW_ONLY(50.55, "Paint for room", joseph, E_PurchaseType.OTHER);
		addSomeExpenseFOR_PREVIEW_ONLY(150, "Some bills", mathew, E_PurchaseType.BILLS);
		addSomeExpenseFOR_PREVIEW_ONLY(12, "Launch", eva, E_PurchaseType.SHOPPING);
		addSomeExpenseFOR_PREVIEW_ONLY(24.50, "Train ticket", joseph, E_PurchaseType.TICKET);
		addSomeExpenseFOR_PREVIEW_ONLY(70.70, "Jeans", mathew, E_PurchaseType.BILLS);
		addSomeExpenseFOR_PREVIEW_ONLY(100, "New boots", adam, E_PurchaseType.SHOPPING);
	}
	
	private User addSomeUserFOR_PREVIEW_ONLY(String name, String password, double balance)
	{
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setAccountBalance(balance);
		user.setData(new Date());
		
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		return user;
	}
	
	private void addSomeExpenseFOR_PREVIEW_ONLY(double amount, String discription, User user, E_PurchaseType purchaseType)
	{
		Expense expense = new Expense();
		expense.setAmount(amount);
		expense.setDate(new Date());
		expense.setName(discription);
		expense.setUserID(user);
		expense.setPurchaseType(purchaseType);
		
		entityManager.getTransaction().begin();
		entityManager.persist(expense);
		entityManager.getTransaction().commit();
	}
}
