package mzebrowski.gui.centerPanel;

import java.awt.Color;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mzebrowski.database.domain.PurchaseType;
import mzebrowski.gui.centerPanel.IconShape.IconType;

@SuppressWarnings("serial")
public class RecordTableView extends JTable {

	public RecordTableView() {
		// headers for the table
		String[] columns = new String[] { "Col", "UserName", "Date", "Type", "Amount" };

		// actual data for the table in a 2d array
		Object[][] data = new Object[][] { { new IconShape(Color.RED,25,IconType.RECT), "John", new Date(), PurchaseType.FOOD, 31.20 }, 
			{ new IconShape(Color.GREEN,25,IconType.RECT), "Max", new Date(), PurchaseType.ITEM, 10.30 },
			{ new IconShape(Color.GREEN,25,IconType.RECT), "Mathew", new Date(), PurchaseType.OTHER, 15 } };

		final Class[] columnClass = new Class[] { Icon.class, String.class, Date.class, PurchaseType.class,
				Double.class };

		// create table model with data
		DefaultTableModel model = new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnClass[columnIndex];
			}
		};

		setModel(model);
	}

}
