package mzebrowski.gui.centerPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mzebrowski.gui.GuiElement;

public class ComboBoxFilter<T> extends JPanel implements GuiElement {

	private JLabel filterLabel;
	private JComboBox<T> optionList;
	
	public ComboBoxFilter(String labelName) {		
		filterLabel = new JLabel(labelName);	
		optionList = new JComboBox<T>();	
	}

	public void setOptionListData(ArrayList<T> list)
	{
		for(T itr: list)
			optionList.addItem(itr);
	}

	public void addAllOption() {
		//optionList.addItem("All");
	}

	public void initLayout() {
		setLayout(new GridLayout(2, 0));
		add(filterLabel);
		add(optionList);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		optionList.addActionListener(actionListener);
	}

	public void setChoosingEnabled(boolean enable) {
		optionList.setEnabled(enable);
	}
	
	
	// get the selected item:
	// String selectedBook = (String) optionList.getSelectedItem();
	// System.out.println("You seleted the book: " + selectedBook);
}
