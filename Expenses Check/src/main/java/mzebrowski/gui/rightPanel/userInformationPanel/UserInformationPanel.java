package mzebrowski.gui.rightPanel.userInformationPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import mzebrowski.gui.GuiElement;

@SuppressWarnings("serial")
public class UserInformationPanel extends JPanel implements GuiElement {
	JLabel lastUpdate, ownExpenses, groupExpenses;

	public UserInformationPanel(JLabel ownExpenses, JLabel groupExpenses, JLabel lastUpdate) {
		this.ownExpenses = ownExpenses;
		this.groupExpenses = groupExpenses;
		this.lastUpdate = lastUpdate;
	}

	public void initLayout() {
		GridLayout gridLayout = new GridLayout(3, 0, 10, 0);
		setLayout(gridLayout);

		ownExpenses.setBorder(BorderFactory.createTitledBorder("Own expenses: "));
		add(ownExpenses);

		groupExpenses.setBorder(BorderFactory.createTitledBorder("Group expenses: "));
		add(groupExpenses);

		lastUpdate.setBorder(BorderFactory.createTitledBorder("Last updated: "));
		add(lastUpdate);

		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

	}

	public void initActionsAndListeners(ActionListener actionListener) {
		
	}
}
