package mzebrowski.gui.rightPanel;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UserInformationPanel extends JPanel {
	JLabel nameLabel, accountBalance, lastUpdate;
	TitledBorder nameLabelTitle, accountBalanceTitle, lastUpdateTitle;

	public UserInformationPanel() {

		GridLayout gridLayout = new GridLayout(3, 0, 10, 0);
		setLayout(gridLayout);

		nameLabelTitle = BorderFactory.createTitledBorder("Name: ");
		accountBalanceTitle = BorderFactory.createTitledBorder("Account balance: ");
		lastUpdateTitle = BorderFactory.createTitledBorder("Last updated: ");

		nameLabel = new JLabel("Mati");
		nameLabel.setBorder(nameLabelTitle);

		accountBalance = new JLabel("100");
		accountBalance.setBorder(accountBalanceTitle);

		lastUpdate = new JLabel("27.08.2017");
		lastUpdate.setBorder(lastUpdateTitle);

		add(nameLabel);
		add(accountBalance);
		add(lastUpdate);
	}
}
