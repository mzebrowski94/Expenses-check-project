package mzebrowski.gui.rightPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.services.ServiceManager;

public class RightPanelController implements ActionListener, ControllerElement {

	ServiceManager serviceManager;
	RightPanel rightPanel;
	UserLoginPanel userLoginPanel;
	UserInformationPanel userInformationPanel;
	ExpenseAddPanel addExpensePanel;

	public RightPanelController(ServiceManager serviceManager, RightPanel rightPanel) {
		this.serviceManager = serviceManager;
		this.rightPanel = rightPanel;
		this.userLoginPanel = rightPanel.getUserAvatarPanel();
		this.userInformationPanel = rightPanel.getUserInformationPanel();
		this.addExpensePanel = rightPanel.getAddExpensePanel();
	}

	public void loadData() {
		addExpensePanel.loadData((ArrayList<User>) serviceManager.getAllUsers());
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == E_RightPanelActions.LOGIN.actionName()) {
			proceedLogin();	
		}
		
	}

	public void initListeners() {
		userLoginPanel.initActionsAndListeners(this);
	}

	private void proceedLogin()
	{
		String password = userLoginPanel.getInsertedPassword();
		String login = userLoginPanel.getInsertedLogin();
		if(password.equals("") || login.equals(""))
			JOptionPane.showMessageDialog(null, "Empty login or password field.\nTry again.", "Empty login or password field.", JOptionPane.ERROR_MESSAGE);
		else
		{
			if(serviceManager.loginAuthorization(login,password))
				{
				addExpensePanel.setAddingEnabled(true);
				//JOptionPane.showMessageDialog(null, "OK");
				}
			else
				JOptionPane.showMessageDialog(null, "Incorrect login or password.\nTry again.", "Authorization error.", JOptionPane.ERROR_MESSAGE);
		}
			
	}
}
