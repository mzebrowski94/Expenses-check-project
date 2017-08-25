package mzebrowski.gui.rightPanel;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class RightPanel extends JPanel {

	UserAvatarPanel userAvatarPanel;
	UserInformationPanel userInformationPanel;
	ExpenseAddPanel addExpensePanel;
	
	public RightPanel(UserAvatarPanel userAvatarPanel,UserInformationPanel userInformationPanel,ExpenseAddPanel addExpensePanel) {
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);

		this.userAvatarPanel = userAvatarPanel;
		add(userAvatarPanel);
		
		this.userInformationPanel = userInformationPanel;
		add(userInformationPanel);
		
		this.addExpensePanel = addExpensePanel;
		add(addExpensePanel);
		
		setBorder(BorderFactory.createLoweredBevelBorder());
	}
}
