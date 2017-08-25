package mzebrowski.gui.centerPanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

import mzebrowski.gui.centerPanel.IconShape.IconType;

public class CenterPanelFactory {
	
	public CenterPanel build()
	{
		CenterPanel centerPanel = new CenterPanel(
				new Toolbar(
						new ComboBoxFilter("Check expenses for:"),
						new ComboBoxFilter("Filter income:"),
						new ComboBoxFilter("Type:"),
						new JButton(new IconShape(Color.GREEN,25,IconType.PLUS)),
						new JButton(new IconShape(Color.RED,25,IconType.MINUS))
						),
				new RecordTable(new Dimension(500, 500)),
				new StatusBar()
				);
		return centerPanel;
	}
		
}
