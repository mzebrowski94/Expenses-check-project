package mzebrowski.database.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import mzebrowski.database.domain.Expense;


public class ExpenseDAO extends GenericDAO<Expense> {

	public ExpenseDAO(EntityManager entityManager, String tableName) {
		super(entityManager, tableName);
	}

	@Override
	public List<Expense> getAll() {
		return entityManager.createQuery("from Expense", Expense.class).getResultList();
	}

	@Override
	public List<String> getAllNames() {
		return entityManager.createQuery("e.name from Expense e", String.class).getResultList();
	}
	
	public List<String> getExpenseRaport();
	{
		
	}

}
