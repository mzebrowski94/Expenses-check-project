package mzebrowski.gui.rightPanel;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class RightPanelView extends JPanel {

	UserAvatarPanel userAvatarPanel;
	UserInformationPanel userInformationPanel;
	AddExpensePanel addExpensePanel;
	
	public RightPanelView() {
		super();
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);

		// Add user avatar Panel
		userAvatarPanel = new UserAvatarPanel();
		add(userAvatarPanel);

		// Add user informations Panel
		userInformationPanel = new UserInformationPanel();
		userInformationPanel.setBorder(new EmptyBorder(15,0,15, 0));
		add(userInformationPanel);
		
		//Add add explen panel
		addExpensePanel = new AddExpensePanel();
		add(addExpensePanel);
		
		setBorder(BorderFactory.createLoweredBevelBorder());
	}
}
