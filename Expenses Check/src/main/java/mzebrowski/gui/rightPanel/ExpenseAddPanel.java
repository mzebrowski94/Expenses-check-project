package mzebrowski.gui.rightPanel;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import mzebrowski.gui.centerPanel.ComboBoxFilter;

@SuppressWarnings("serial")
public class ExpenseAddPanel extends JPanel {

	ComboBoxFilter userComboBox, typeComboBox, dateComboBox;
	AmountField amountField;
	JButton addButon;
	
	public ExpenseAddPanel(ComboBoxFilter userComboBox, ComboBoxFilter typeComboBox, ComboBoxFilter dateComboBox, AmountField amountField, JButton addButon) {

		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		setBorder(border);
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);

		this.userComboBox = userComboBox;
		userComboBox.setBorder(border);
		add(userComboBox);
		
		this.typeComboBox = typeComboBox;
		typeComboBox.setBorder(border);
		add(typeComboBox);
		
		this.dateComboBox = dateComboBox;
		dateComboBox.setBorder(border);
		add(dateComboBox);
		
		this.amountField = amountField;
		add(amountField);
		
		this.addButon = addButon;
		addButon.setToolTipText("Add expense");
		add(addButon);
		
	}
}
