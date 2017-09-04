package mzebrowski.database.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import mzebrowski.database.DAOManager;
import mzebrowski.database.DAOs.ExpenseDAO;
import mzebrowski.database.DAOs.UserDAO;
import mzebrowski.database.domain.E_ExpenseType;
import mzebrowski.database.domain.E_TableType;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.database.domain.user.User;

public class ServiceManager {

	private DAOManager daoManager;
	private ExpenseDAO expenseDAO;
	private UserDAO userDAO;

	public ServiceManager(DAOManager daoManager) {
		this.daoManager = daoManager;
		try {
			this.expenseDAO = (ExpenseDAO) daoManager.getDAO(E_TableType.EXPENSE);
			this.userDAO = (UserDAO) daoManager.getDAO(E_TableType.USER);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot initialize serviceManager");
		}
	}

	public List<User> getAllUsers() {
		return userDAO.getAll();
	}

	public List<Expense> getAllExpenses() {
		return expenseDAO.getAll();
	}

	public List<String> getUsersExpensesRaportThisMonth(E_ExpenseType expenseType) {
		LocalDate dateWeekEalier = LocalDate.now().minusWeeks(1);
		Date date = java.sql.Date.valueOf(dateWeekEalier);
		return expenseDAO.getAllUsersExpensesRaportToDate(date, expenseType);
	}

	public User proceedUserLogin(String userName, String password) {
		User user = userDAO.getUser(userName);
		if (user != null && user.getPassword().equals(password))
			return user;
		else
			return null;
	}

	public void addNewRecord(Expense expense) {
		EntityManager entityManager = daoManager.getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(expense);
		entityManager.getTransaction().commit();
	}

	public String getExpenseRaportForUser(User user, E_ExpenseType expenseType) {
		Double userExpenses = expenseDAO.getUserExpensesAmount(user, expenseType);
		Double allUsersExpenses = expenseDAO.getAllUsersExpensesAmount(expenseType);
		if (userExpenses != null && allUsersExpenses != null) {
			Integer percent = (int) ((userExpenses / allUsersExpenses) * 100);
			return userExpenses.toString() + " which is " + percent.toString() + "%" + "of all.";
		} else {
			return null;
		}

	}

	// List<Object> objectList;
	// List<Double> amountList = new ArrayList<Double>();
	// objectList = expenseDAO.getValueWithID(1,
	// E_ExpenseTableAttributes.AMOUNT.getAttributeName());
	// for(Object obj : objectList)
	// {
	// if(obj instanceof Double)
	// amountList.add((Double) obj);
	// }
	//
	// return null;

}
