package mzebrowski.gui.centerPanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import mzebrowski.database.domain.E_ExpenseType;
import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.gui.additionalComponents.ComboBoxFilter;
import mzebrowski.gui.additionalComponents.IconShape;
import mzebrowski.gui.additionalComponents.IconShape.IconType;
import mzebrowski.gui.centerPanel.filterToolbar.ComboBoxesToolbar;
import mzebrowski.gui.centerPanel.raportPanel.RaportPanel;
import mzebrowski.gui.centerPanel.recordTable.RecordTable;

public class CenterPanelFactory {
	
	public CenterPanel build()
	{
		CenterPanel centerPanel = new CenterPanel(
				new ComboBoxesToolbar(
						new ComboBoxFilter<User>("Check expenses for:", ComboBoxFilter.ADD_ALL_OPTION),
						new ComboBoxFilter<E_ExpenseType>("Expense type:", ComboBoxFilter.ADD_ALL_OPTION),
						new ComboBoxFilter<E_PurchaseType>("Type:", ComboBoxFilter.ADD_ALL_OPTION),
						new JButton(new IconShape(Color.GREEN,25,IconType.PLUS)),
						new JButton(new IconShape(Color.RED,25,IconType.MINUS))
						),
				new RecordTable(),
				new RaportPanel(new JLabel("Status: Online "))
				);
		return centerPanel;
	}	
}
