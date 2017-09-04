package mzebrowski.database.DAOs;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mzebrowski.database.domain.E_ExpenseType;
import mzebrowski.database.domain.E_TableType;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.database.domain.user.User;

public class ExpenseDAO extends GenericDAO<Expense> {

	public ExpenseDAO(EntityManager entityManager, E_TableType tableType) {
		super(entityManager, tableType);
	}

	@Override
	public List<Expense> getAll() {
		return entityManager.createQuery("from Expense", Expense.class).getResultList();
	}

	@Override
	public List<String> getAllNames() {
		return entityManager.createQuery("e.name from Expense e", String.class).getResultList();
	}

	public List<String> getAllUsersExpensesRaportToDate(Date date, E_ExpenseType expenseType) {
		Query query = entityManager.createQuery(
				"select CONCAT(e.user.userName,' ', SUM(e.amount)) from Expense e WHERE e.date > :date AND e.expenseType = :expenseType GROUP BY e.user ORDER BY SUM(e.amount) DESC",
				String.class);
		query.setParameter("date", date);
		query.setParameter("expenseType", expenseType);

		return query.getResultList();
	}
	
	public Double getUserExpensesAmount(User user, E_ExpenseType expenseType) {
		Query query = entityManager.createQuery(
				"select SUM(e.amount) from Expense e WHERE e.user = :user AND e.expenseType = :expenseType",
				Double.class);
		query.setParameter("user", user);
		query.setParameter("expenseType", expenseType);

		return (Double) query.getSingleResult();
	}
	
	public Double getAllUsersExpensesAmount(E_ExpenseType expenseType) {
		Query query = entityManager.createQuery(
				"select SUM(e.amount) from Expense e WHERE e.expenseType = :expenseType",
				Double.class);
		query.setParameter("expenseType", expenseType);

		return (Double) query.getSingleResult();
	}

}
