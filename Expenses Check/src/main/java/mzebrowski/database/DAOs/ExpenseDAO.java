package mzebrowski.database.DAOs;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import mzebrowski.database.domain.enums.E_ExpenseType;
import mzebrowski.database.domain.enums.E_PurchaseType;
import mzebrowski.database.domain.enums.E_TableType;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.domain.wrappers.UserSumExpensesWrapper;

public class ExpenseDAO extends GenericDAO<Expense> {

	public ExpenseDAO(EntityManager entityManager, CriteriaBuilder criteriaBuilder, E_TableType tableType) {
		super(entityManager, criteriaBuilder, tableType);
	}

	@Override
	public List<Expense> getAll() {
		return entityManager.createQuery("from Expense", Expense.class).getResultList();
	}

	@Override
	public List<String> getAllNames() {
		return entityManager.createQuery("e.name from Expense e", String.class).getResultList();
	}

	public List<UserSumExpensesWrapper> getAllUsersSumExpensesBetween(E_ExpenseType expenseType, Date startDate,
			Date endDate) {

		String queryStr = "select "
				+ "NEW mzebrowski.database.domain.wrappers.UserSumExpensesWrapper(e.user, SUM(e.amount)) "
				+ "from Expense e "
				+ "WHERE e.date "
				+ "BETWEEN :startDate AND :endDate "
				+ "AND e.expenseType = :expenseType  "
				+ "GROUP BY e.user "
				+ "ORDER BY SUM(e.amount) DESC";

		TypedQuery<UserSumExpensesWrapper> query = entityManager.createQuery(queryStr, UserSumExpensesWrapper.class);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		query.setParameter("expenseType", expenseType);

		return query.getResultList();
	}

	public Double getUserExpensesSum(User user, E_ExpenseType expenseType) {
		Query query = entityManager.createQuery(
				"select SUM(e.amount) from Expense e WHERE e.user = :user AND e.expenseType = :expenseType",
				Double.class);
		query.setParameter("user", user);
		query.setParameter("expenseType", expenseType);

		return (Double) query.getSingleResult();
	}

	public Double getAllUsersExpensesSum(E_ExpenseType expenseType) {
		Query query = entityManager
				.createQuery("select SUM(e.amount) from Expense e WHERE e.expenseType = :expenseType", Double.class);
		query.setParameter("expenseType", expenseType);

		return (Double) query.getSingleResult();
	}

	public List<Expense> getExpensesFiltered(User userFilter, E_ExpenseType expenseTypeFilter,
			E_PurchaseType purchaseTypeFilter) {

		Query query = entityManager.createQuery("from Expense e WHERE " + "(:user is null OR e.user = :user) AND"
				+ "(:expenseType is null OR e.expenseType = :expenseType) AND"
				+ "(:purchaseType is null OR e.purchaseType = :purchaseType)", Expense.class);
		query.setParameter("user", userFilter);
		query.setParameter("expenseType", expenseTypeFilter);
		query.setParameter("purchaseType", purchaseTypeFilter);

		return query.getResultList();
	}

	public Double getAvarageUsersExpensesBetween(E_ExpenseType expenseType, Date startDate, Date endDate) {

		Query query = entityManager.createQuery(
				"select AVG(e.amount) from Expense e WHERE e.date BETWEEN :startDate AND :endDate AND e.expenseType = :expenseType",
				Double.class);
		query.setParameter("expenseType", expenseType);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return (Double) query.getSingleResult();

	}

}
