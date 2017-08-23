package mzebrowski.gui.centerPanel;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ComboBoxFilter extends JPanel {

	JLabel filterLabel;
	JComboBox<String> optionList;
	String[] data = new String[] { "Effective Java", "Head First Java", "Thinking in Java",
	"Java for Dummies" };
	
	public ComboBoxFilter(String labelName) {
		setLayout(new GridLayout(2, 0));

		filterLabel = new JLabel(labelName);
		optionList = new JComboBox<String>(data);

		add(filterLabel);
		add(optionList);
	}

	// get the selected item:
	// String selectedBook = (String) optionList.getSelectedItem();
	// System.out.println("You seleted the book: " + selectedBook);
}
