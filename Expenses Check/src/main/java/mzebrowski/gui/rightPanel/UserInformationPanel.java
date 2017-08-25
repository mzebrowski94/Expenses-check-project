package mzebrowski.gui.rightPanel;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UserInformationPanel extends JPanel {
	JLabel nameLabel, accountBalance, lastUpdate;

	public UserInformationPanel(JLabel nameLabel,JLabel accountBalance,JLabel lastUpdate) {

		GridLayout gridLayout = new GridLayout(3, 0, 10, 0);
		setLayout(gridLayout);

		this.nameLabel = nameLabel;
		nameLabel.setBorder(BorderFactory.createTitledBorder("Name: "));
		add(nameLabel);
		
		this.accountBalance = accountBalance;
		accountBalance.setBorder(BorderFactory.createTitledBorder("Account balance: "));
		add(accountBalance);
		
		this.lastUpdate = lastUpdate;
		lastUpdate.setBorder(BorderFactory.createTitledBorder("Last updated: "));
		add(lastUpdate);
		
		this.setBorder(new EmptyBorder(15,0,15, 0));
	}
}
