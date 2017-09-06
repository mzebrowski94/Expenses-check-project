package mzebrowski.gui.rightPanel;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
		
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(userLoginPanel);
		add(userInformationPanel);
		add(addExpensePanel);
		setBorder(BorderFactory.createLoweredBevelBorder());
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
	}

}
