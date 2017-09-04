package mzebrowski.gui.rightPanel.userLoginPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.services.ServiceManager;
import mzebrowski.gui.rightPanel.E_RightPanelActions;
import mzebrowski.gui.rightPanel.ValueField;

public class UserLoginPanelController implements ControllerElement {

	ServiceManager serviceManager;
	UserLoginPanel userLoginPanel;
	ValueField loginField, passwordField;
	JButton loginButton, logoutButton;

	public UserLoginPanelController(ServiceManager serviceManager, UserLoginPanel userLoginPanel) {
		this.serviceManager = serviceManager;
		this.userLoginPanel = userLoginPanel;
		this.loginField = userLoginPanel.getLoginField();
		this.passwordField = userLoginPanel.getPasswordField();
		this.loginButton = userLoginPanel.getLoginButton();
		this.logoutButton = userLoginPanel.getLogoutButton();
	}

	public void initListeners(ActionListener actionListener) {
		userLoginPanel.initActionsAndListeners(actionListener);
	}

	public boolean proceedLogin() {
		String password = passwordField.getInsertedText();
		String login = loginField.getInsertedText();
		if (password.equals("") || login.equals("")) {
			JOptionPane.showMessageDialog(null, "Empty login or password field.\nTry again.",
					"Empty login or password field.", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			if (serviceManager.loginAuthorization(login, password)) {
				loginButton.setEnabled(false);
				logoutButton.setEnabled(true);
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect login or password.\nTry again.", "Authorization error.",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
	}

	public void proceedLogout() {
		// TO DO: CONNECT AND MARGE
		System.out.println("logout");
		loginButton.setEnabled(true);
		logoutButton.setEnabled(false);
		loginField.setInsertedText("");
		passwordField.setInsertedText("");
	}

	public void loadData() {
		// TODO Auto-generated method stub
		
	}
}
