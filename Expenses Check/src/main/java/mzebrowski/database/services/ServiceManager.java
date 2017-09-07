package mzebrowski.database.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import mzebrowski.database.DAOManager;
import mzebrowski.database.DAOs.ExpenseDAO;
import mzebrowski.database.DAOs.UserDAO;
import mzebrowski.database.domain.enums.E_ExpenseType;
import mzebrowski.database.domain.enums.E_PurchaseType;
import mzebrowski.database.domain.enums.E_TableType;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.domain.wrappers.UserSumExpensesWrapper;

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

	public List<UserSumExpensesWrapper> getUsersExpensesRaportBetween(E_ExpenseType expenseType, LocalDate startDate, LocalDate endDate) {
		return expenseDAO.getAllUsersSumExpensesBetween(expenseType,toUtilDate(startDate),toUtilDate(endDate));
	}

	public Date toUtilDate(LocalDate localDate)
	{
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
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

		Double userExpensesSum = expenseDAO.getUserExpensesSum(user, expenseType);
		Integer percent;
		String endLine;

		if (expenseType == E_ExpenseType.OWN) {
			Double userGroupExpensesSum = expenseDAO.getUserExpensesSum(user, E_ExpenseType.GROUP);
			if (userExpensesSum != null && userGroupExpensesSum != null) {
				Double allUserExpensesSum = userExpensesSum + userGroupExpensesSum;
				percent = (int) ((userExpensesSum / allUserExpensesSum) * 100);
				endLine = "% of your expenses.";
			} else {
				return null;
			}
		} else {
			Double allUsersExpenses = expenseDAO.getAllUsersExpensesSum(expenseType);
			if (userExpensesSum != null && allUsersExpenses != null) {
				percent = (int) ((userExpensesSum / allUsersExpenses) * 100);
				endLine = "% of group expenses.";
			} else {
				return null;
			}
		}
		return userExpensesSum.toString() + " (" + percent.toString() + endLine + ")";
	}

	public ArrayList<Expense> getExpensesFiltered(User userFilter, E_ExpenseType expenseTypeFilter,
			E_PurchaseType purchaseTypeFilter) {
		return (ArrayList<Expense>) expenseDAO.getExpensesFiltered(userFilter, expenseTypeFilter, purchaseTypeFilter);
	}

	public Double getAverageUsersExpensesBetween(E_ExpenseType expenseType, LocalDate startDate, LocalDate endDate) {
		return expenseDAO.getAvarageUsersExpensesBetween(expenseType, toUtilDate(startDate),toUtilDate(endDate));
		
	}

}
