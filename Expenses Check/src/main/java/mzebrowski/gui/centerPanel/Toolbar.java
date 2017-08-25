package mzebrowski.gui.centerPanel;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import mzebrowski.gui.centerPanel.IconShape.IconType;

@SuppressWarnings("serial")
public class Toolbar extends JToolBar{
	
	ComboBoxFilter checkExpenses;
	ComboBoxFilter incomeFilter;
	ComboBoxFilter typeFilter;
	JButton plusButton;
	JButton minusButton;
	
	
	public Toolbar (ComboBoxFilter checkExpenses, ComboBoxFilter incomeFilter, ComboBoxFilter typeFilter, JButton plusButton, JButton minusButton)
	{
		setFloatable(false);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setMargin(new Insets(10, 5, 5, 5));
		
		this.checkExpenses = checkExpenses;
		add(checkExpenses);
		
		this.incomeFilter = incomeFilter;
		add(incomeFilter);
		
		this.typeFilter = typeFilter;
		add(typeFilter);
		
		this.plusButton = plusButton;
		add(plusButton);
		
		this.minusButton = minusButton;
		add(minusButton);
	}
}
