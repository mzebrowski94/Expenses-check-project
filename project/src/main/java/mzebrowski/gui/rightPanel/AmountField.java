package mzebrowski.gui.rightPanel;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class AmountField extends JPanel {

	JLabel amountLabel;
	JTextField amountTextField;

	public AmountField() {
		setLayout(new GridLayout(0, 2));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

		amountLabel = new JLabel("Amount: ");
		amountTextField = new JTextField("0");
		amountLabel.setLabelFor(amountTextField);
		add(amountLabel);
		add(amountTextField);
	}

}
