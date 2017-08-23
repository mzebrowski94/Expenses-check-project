package mzebrowski.gui.rightPanel;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import mzebrowski.gui.centerPanel.ComboBoxFilter;

@SuppressWarnings("serial")
public class AddExpensePanel extends JPanel {

	
	private Border border;
	ComboBoxFilter userComboBox, typeComboBox, dateComboBox;
	AmountField amountField;
	JButton addButon;
	
	public AddExpensePanel() {

		border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		setBorder(border);
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
//		GridLayout gridLayout = new GridLayout(5, 0);
//		setLayout(gridLayout);

		userComboBox = new ComboBoxFilter("User: ");
		userComboBox.setBorder(border);

		typeComboBox = new ComboBoxFilter("Purchase type: ");
		typeComboBox.setBorder(border);

		dateComboBox = new ComboBoxFilter("Date: ");
		dateComboBox.setBorder(border);
		
		amountField = new AmountField();
		
		addButon = new JButton("Add");
		addButon.setToolTipText("Add expense");
		
		add(userComboBox);
		add(typeComboBox);
		add(dateComboBox);
		add(amountField);
		add(addButon);

	}
}
