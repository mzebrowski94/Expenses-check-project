package mzebrowski.gui.rightPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import mzebrowski.gui.GuiElement;
import mzebrowski.gui.rightPanel.expenseAddPanel.ExpenseAddPanel;
import mzebrowski.gui.rightPanel.userInformationPanel.UserInformationPanel;
import mzebrowski.gui.rightPanel.userLoginPanel.UserLoginPanel;

@SuppressWarnings("serial")
public class RightPanel extends JPanel implements GuiElement {

	UserLoginPanel userLoginPanel;
	UserInformationPanel userInformationPanel;
	ExpenseAddPanel addExpensePanel;

	public RightPanel(UserLoginPanel userLoginPanel, UserInformationPanel userInformationPanel,
			ExpenseAddPanel addExpensePanel) {
		this.userLoginPanel = userLoginPanel;
		this.userInformationPanel = userInformationPanel;
		this.addExpensePanel = addExpensePanel;
	}

	public UserLoginPanel getUserAvatarPanel() {
		return userLoginPanel;
	}

	public UserInformationPanel getUserInformationPanel() {
		return userInformationPanel;
	}

	public ExpenseAddPanel getAddExpensePanel() {
		return addExpensePanel;
	}

	public void initLayout() {
		userLoginPanel.initLayout();
		userInformationPanel.initLayout();
		addExpensePanel.initLayout();
		
		GridLayout layout = new GridLayout(3, 0);
		setLayout(layout);
		add(userLoginPanel);
		add(userInformationPanel);
		add(addExpensePanel);
		setBorder(BorderFactory.createLoweredBevelBorder());
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
	}

}
