package mzebrowski.gui.rightPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import mzebrowski.gui.GuiElement;

@SuppressWarnings("serial")
public class UserInformationPanel extends JPanel implements GuiElement {
	JLabel nameLabel, accountBalance, lastUpdate;

	public UserInformationPanel(JLabel nameLabel, JLabel accountBalance, JLabel lastUpdate) {
		this.nameLabel = nameLabel;
		this.accountBalance = accountBalance;
		this.lastUpdate = lastUpdate;
	}

	public void initLayout() {
		GridLayout gridLayout = new GridLayout(3, 0, 10, 0);
		setLayout(gridLayout);

		nameLabel.setBorder(BorderFactory.createTitledBorder("Name: "));
		add(nameLabel);

		accountBalance.setBorder(BorderFactory.createTitledBorder("Account balance: "));
		add(accountBalance);

		lastUpdate.setBorder(BorderFactory.createTitledBorder("Last updated: "));
		add(lastUpdate);

		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		
	}
}
