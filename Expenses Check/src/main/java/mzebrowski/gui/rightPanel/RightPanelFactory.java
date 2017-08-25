package mzebrowski.gui.rightPanel;

import javax.swing.JButton;
import javax.swing.JLabel;

import mzebrowski.gui.centerPanel.ComboBoxFilter;

public class RightPanelFactory {
		
		public RightPanel build()
		{
			RightPanel rightPanel = new RightPanel(
						new UserAvatarPanel(),
						new UserInformationPanel(
								new JLabel("Default Name"),
								new JLabel("100"),
								new JLabel("27.08.2017")
								),
						new ExpenseAddPanel(
								 new ComboBoxFilter("User: "),
								 new ComboBoxFilter("Purchase type: "),
								 new ComboBoxFilter("Date: "),
								 new AmountField(),
								 new JButton("Add")
								)
					);
		
			return rightPanel;
		}
		
		
}
