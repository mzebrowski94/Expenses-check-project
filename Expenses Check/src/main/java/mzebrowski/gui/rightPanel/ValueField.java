package mzebrowski.gui.rightPanel;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
public class ValueField extends JPanel {

	JLabel amountLabel;
	JTextComponent amountTextField;

	public ValueField(JTextComponent field, String labelDiscription, String defautlText) {
		setLayout(new GridLayout(2, 0));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

		amountLabel = new JLabel(labelDiscription);
		amountTextField = field;
		amountLabel.setLabelFor(amountTextField);
		add(amountLabel);
		add(amountTextField);
	}

}
