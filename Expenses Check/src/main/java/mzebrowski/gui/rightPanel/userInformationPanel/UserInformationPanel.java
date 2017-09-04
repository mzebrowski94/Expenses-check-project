package mzebrowski.gui.rightPanel.userInformationPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import mzebrowski.gui.GuiElement;

@SuppressWarnings("serial")
public class UserInformationPanel extends JPanel implements GuiElement {
	JLabel ownExpenses, groupExpenses;

	public UserInformationPanel(JLabel ownExpenses, JLabel groupExpenses, JLabel lastUpdate) {
		this.ownExpenses = ownExpenses;
		this.groupExpenses = groupExpenses;
	}

	public void initLayout() {
		
		setLayout(new GridBagLayout());

		ownExpenses.setBorder(BorderFactory.createTitledBorder("Own expenses: "));
		//ownExpenses.setPreferredSize(new Dimension(100, 30));
		add(ownExpenses,createConstraints(GridBagConstraints.BOTH, 0, 0, 1, 1));

		groupExpenses.setBorder(BorderFactory.createTitledBorder("Group expenses: "));
		//groupExpenses.setPreferredSize(new Dimension(100, 30));
		add(groupExpenses,createConstraints(GridBagConstraints.BOTH, 0, 1, 1, 1));

		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}

	private GridBagConstraints createConstraints(int fillType, int gridx, int gridy, double weightx, double weighty) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = fillType;
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		return constraints;
	}
	
	public void initActionsAndListeners(ActionListener actionListener) {
		
	}

	public JLabel getOwnExpenses() {
		return ownExpenses;
	}

	public JLabel getGroupExpenses() {
		return groupExpenses;
	}
	
	
}
