package mzebrowski.gui.rightPanel;


import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RightPanel extends JPanel {

	UserLoginPanel userLoginPanel;
	UserInformationPanel userInformationPanel;
	ExpenseAddPanel addExpensePanel;
	
	public RightPanel(UserLoginPanel userLoginPanel,UserInformationPanel userInformationPanel,ExpenseAddPanel addExpensePanel) {
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		
		this.userLoginPanel = userLoginPanel;
		add(userLoginPanel);
		
		this.userInformationPanel = userInformationPanel;
		add(userInformationPanel);
		
		this.addExpensePanel = addExpensePanel;
		add(addExpensePanel);
		
		setBorder(BorderFactory.createLoweredBevelBorder());
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
	
	
}
