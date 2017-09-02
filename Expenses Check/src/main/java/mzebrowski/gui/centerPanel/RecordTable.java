package mzebrowski.gui.centerPanel;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.gui.GuiElement;

@SuppressWarnings("serial")
public class RecordTable extends JTable implements GuiElement {

	private String[] columnNames;
	private Class[] columnClasses;
	private DefaultTableModel model;
	private Dimension preferedSize;
	
	public RecordTable(Dimension preferedSize) {
		initModel();
	}

	public void updateRecordTableData(ArrayList<Expense> arrayList) {

		Object[][] data = new Object[arrayList.size()][columnNames.length];
		for (int i = 0; i < arrayList.size(); i++) {
			Expense expense = arrayList.get(i);
			data[i] = new Object[] { expense.getUserID().getUserName(), expense.getDate(), expense.getPurchaseType(),
					expense.getName(), expense.getAmount() };
		}

		model.setDataVector(data, columnNames);
	}

	private void initModel() {
		// headers for the table
		columnNames = new String[] { "UserName", "Date", "Type", "Name", "Amount" };
		columnClasses = new Class[] { String.class, Date.class, E_PurchaseType.class, String.class, Double.class };

		// // create table model
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnClasses[columnIndex];
			}
		};

		this.setModel(model);
	}

	public void initLayout() {
		this.setPreferredSize(preferedSize);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
			
	}

}
