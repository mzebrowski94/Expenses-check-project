package mzebrowski.database.DAOs;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mzebrowski.database.domain.E_TableType;
import mzebrowski.database.domain.expense.Expense;

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

	public List<String> getUserExpensesRaportToDate(Date date)
	{
		Query query = entityManager.createQuery("select CONCAT(e.userID.userName,' ', SUM(e.amount)) from Expense e WHERE e.date > :date GROUP BY e.userID ORDER BY SUM(e.amount) DESC", String.class);
		query.setParameter("date", date);
		
		return query.getResultList();
	}

}
