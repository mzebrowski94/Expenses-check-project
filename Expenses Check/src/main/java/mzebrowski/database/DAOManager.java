package mzebrowski.database;

import java.sql.SQLException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;

import mzebrowski.database.DAOs.ExpenseDAO;
import mzebrowski.database.DAOs.GenericDAO;
import mzebrowski.database.DAOs.UserDAO;
import mzebrowski.database.domain.enums.E_AccesType;
import mzebrowski.database.domain.enums.E_ExpenseType;
import mzebrowski.database.domain.enums.E_PurchaseType;
import mzebrowski.database.domain.enums.E_TableType;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.database.domain.user.User;

public class DAOManager {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private CriteriaBuilder criteriaBuilder;
	
	public DAOManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.entityManagerFactory = entityManager.getEntityManagerFactory();
		this.criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
		addSomeRandomDataFOR_PREVIEW_ONLY();
	}

	public GenericDAO getDAO(E_TableType tableType) throws SQLException {

		switch (tableType) {
		case EXPENSE:
			return new ExpenseDAO(entityManager,criteriaBuilder, E_TableType.EXPENSE);
		case USER:
			return new UserDAO(entityManager,criteriaBuilder, E_TableType.USER);
		default:
			throw new SQLException("Trying to link to an unexistant table.");
		}
	}

	public void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}

	private void addSomeRandomDataFOR_PREVIEW_ONLY() {
		User adam = addSomeUserFOR_PREVIEW_ONLY("Adam","password",E_AccesType.ALL_USERS);
		User eva = addSomeUserFOR_PREVIEW_ONLY("Eva","password",E_AccesType.OWN_ONLY);
		User joseph = addSomeUserFOR_PREVIEW_ONLY("Joseph","password",E_AccesType.ALL_USERS);
		User mathew = addSomeUserFOR_PREVIEW_ONLY("Mathew","password",E_AccesType.ALL_USERS);
		User admin = addSomeUserFOR_PREVIEW_ONLY("a","a",E_AccesType.ADMIN);
		
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,3,3),13, "Food for breakfast", adam, E_PurchaseType.FOOD, E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,7,1),6, "Bus ticket", eva, E_PurchaseType.TICKET,E_ExpenseType.OWN);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,1),50.55, "Paint for room", joseph, E_PurchaseType.OTHER,E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,2),150, "Some bills", mathew, E_PurchaseType.BILLS,E_ExpenseType.OWN);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,3),12, "Launch", eva, E_PurchaseType.FOOD,E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(), 24.50, "Train ticket", joseph, E_PurchaseType.TICKET,E_ExpenseType.OWN);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,29),70.70, "Jeans", mathew, E_PurchaseType.SHOPPING,E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,7,29),20, "New boots", adam, E_PurchaseType.SHOPPING,E_ExpenseType.OWN);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,1),45, "Kitchen chair", eva, E_PurchaseType.OTHER,E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(),12.50, "Schabowe", mathew, E_PurchaseType.FOOD,E_ExpenseType.OWN);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,4),55, "Carpet", adam, E_PurchaseType.OTHER,E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,5), 30, "Central heat bills", joseph, E_PurchaseType.BILLS,E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,6),3, "Snickers", mathew, E_PurchaseType.FOOD,E_ExpenseType.OWN);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,1),99.99, "New boots", mathew, E_PurchaseType.SHOPPING,E_ExpenseType.OWN);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(), 10, "Stencils", eva, E_PurchaseType.SHOPPING,E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,3),5, "Warsaw map", joseph, E_PurchaseType.SHOPPING,E_ExpenseType.OWN);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,7),45, "Car fuel", joseph, E_PurchaseType.BILLS,E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(), 700, "Bike", adam, E_PurchaseType.OTHER,E_ExpenseType.OWN);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,3),25, "Clock", eva, E_PurchaseType.OTHER,E_ExpenseType.GROUP);
		addSomeExpenseFOR_PREVIEW_ONLY(new Date(117,8,6),150, "Train tickets", adam, E_PurchaseType.TICKET,E_ExpenseType.GROUP);
	}
	
	private User addSomeUserFOR_PREVIEW_ONLY(String name, String password, E_AccesType accesType)
	{
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setData(new Date());
		user.setAccesType(accesType);
		
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		return user;
	}
	
	private void addSomeExpenseFOR_PREVIEW_ONLY(Date date, double amount, String discription, User user, E_PurchaseType purchaseType, E_ExpenseType expenseType)
	{
		Expense expense = new Expense();
		expense.setAmount(amount);
		expense.setDate(date);
		expense.setDiscription(discription);
		expense.setUser(user);
		expense.setPurchaseType(purchaseType);
		expense.setExpenseType(expenseType);
		
		entityManager.getTransaction().begin();
		entityManager.persist(expense);
		entityManager.getTransaction().commit();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
}
