package mzebrowski.gui.centerPanel.recordTable;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.enums.E_ExpenseType;
import mzebrowski.database.domain.enums.E_PurchaseType;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.services.ServiceManager;

public class RecordTableController implements ControllerElement {
	
	private ServiceManager serviceManager; 
	private RecordTable recordTable;
	private DefaultTableModel tableModel;
	private String[] columnNames;
	private Class[] columnClasses;
	
	public RecordTableController(ServiceManager serviceManager, RecordTable recordTable)
	{
		this.serviceManager =serviceManager;
		this.recordTable =recordTable;
		this.tableModel = null;
	}
	
	public void initListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
	}

	public void loadData() {
		tableModel = initRecordTableData((ArrayList<Expense>) serviceManager.getAllExpenses());
		recordTable.setModel(tableModel);
	}
	
	public void updateTableData(User userFilter, E_ExpenseType expenseTypeFilter, E_PurchaseType purchaseTypeFilter)
	{
		ArrayList<Expense> expenses = (ArrayList<Expense>) serviceManager.getExpensesFiltered(userFilter,expenseTypeFilter,purchaseTypeFilter);
		
		Object[][] data = new Object[expenses.size()][columnNames.length];
		for (int i = 0; i < expenses.size(); i++) {
			Expense expense = expenses.get(i);
			data[i] = new Object[] { expense.getUser().getUserName(), expense.getDate(), expense.getPurchaseType(),
					expense.getExpenseType(),expense.getDiscription(), expense.getAmount() };
		}
		
		tableModel.setDataVector(data, columnNames);
	}
	
	public DefaultTableModel initRecordTableData(ArrayList<Expense> arrayList) {	
		DefaultTableModel tableModel = initModel();	
		this.updateTableData(null,null,null);
		return tableModel;
	}

	private DefaultTableModel initModel() {
		// headers for the table
		columnNames = new String[] { "UserName", "Date", "Purchase Type", "Expense Type", "Name", "Amount" };
		columnClasses = new Class[] { String.class, Date.class, E_PurchaseType.class, E_ExpenseType.class, String.class,
				Double.class };

		// // create table tableModel
		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnClasses[columnIndex];
			}
		};

		
		return tableModel;
	}

}
