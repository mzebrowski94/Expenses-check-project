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
public class ToolbarView extends JToolBar{
	
	public ToolbarView ()
	{
		super();
		setFloatable(false);
		
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(boxLayout);
		setMargin(new Insets(10, 5, 5, 5));
		
		ComboBoxFilter checkExpenses = new ComboBoxFilter("Check expenses for:");
		checkExpenses.setBorder(new EmptyBorder(10,10,10, 10));
		add(checkExpenses);
		
		ComboBoxFilter incomeFilter = new ComboBoxFilter("Filter income:");
		incomeFilter.setBorder(new EmptyBorder(10,10,10, 10));
		add(incomeFilter);
		
		ComboBoxFilter typeFilter = new ComboBoxFilter("Type:");
		typeFilter.setBorder(new EmptyBorder(10,10,10, 10));
		add(typeFilter);
		
		Icon icon = new IconShape(Color.GREEN,25,IconType.PLUS);
		JButton bexit = new JButton(icon);
        bexit.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(bexit);		
        
		Icon icon2 = new IconShape(Color.RED,25,IconType.MINUS);
		JButton bexit2 = new JButton(icon2);
        bexit2.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(bexit2);	
	}
}
