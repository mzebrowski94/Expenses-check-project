package mzebrowski.gui.centerPanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.User;
import mzebrowski.gui.centerPanel.IconShape.IconType;

public class CenterPanelFactory {
	
	public CenterPanel build()
	{
		CenterPanel centerPanel = new CenterPanel(
				new ComboBoxesToolbar(
						new ComboBoxFilter<User>("Check expenses for:"),
						new ComboBoxFilter<E_Incomes>("Filter income:"),
						new ComboBoxFilter<E_PurchaseType>("Type:"),
						new JButton(new IconShape(Color.GREEN,25,IconType.PLUS)),
						new JButton(new IconShape(Color.RED,25,IconType.MINUS))
						),
				new RecordTable(
						new Dimension(500, 500)),
				new RaportPanel("Status bar: ", new JEditorPane(), new JLabel("Status: "))
				);
		return centerPanel;
	}
		
}
