package mzebrowski.gui.centerPanel;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxFilter<T> extends JPanel {

	private JLabel filterLabel;
	private JComboBox<T> optionList;
	
	public ComboBoxFilter(String labelName) {
		
		
		setLayout(new GridLayout(2, 0));

		filterLabel = new JLabel(labelName);
		
		
		optionList = new JComboBox<T>();
		
		add(filterLabel);
		add(optionList);
	}

	public void setOptionListData(ArrayList<T> list)
	{
		for(T itr: list)
			optionList.addItem(itr);
	}

	public void addAllOption() {
		//optionList.addItem("All");
	}
	
	
	// get the selected item:
	// String selectedBook = (String) optionList.getSelectedItem();
	// System.out.println("You seleted the book: " + selectedBook);
}
