package mzebrowski.gui.rightPanel.userLoginPanel;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.services.ServiceManager;
import mzebrowski.gui.rightPanel.ValueField;

public class UserLoginPanelController implements ControllerElement {

	private ServiceManager serviceManager;
	private UserLoginPanel userLoginPanel;
	private ValueField loginField, passwordField;
	private JButton loginButton, logoutButton;
	private User loggedUser;

	public UserLoginPanelController(ServiceManager serviceManager, UserLoginPanel userLoginPanel) {
		this.serviceManager = serviceManager;
		this.userLoginPanel = userLoginPanel;
		this.loginField = userLoginPanel.getLoginField();
		this.passwordField = userLoginPanel.getPasswordField();
		this.loginButton = userLoginPanel.getLoginButton();
		this.logoutButton = userLoginPanel.getLogoutButton();
		this.loggedUser = null;
	}

	public void initListeners(ActionListener actionListener) {
		userLoginPanel.initActionsAndListeners(actionListener);
	}

	public boolean proceedLogin() {
		String password = passwordField.getInsertedText();
		String login = loginField.getInsertedText();
		if (password.equals("") || login.equals("")) {
			generatePopupMassage("Empty login or password field.\nTry again.", "Empty login or password field.",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			this.loggedUser = serviceManager.proceedUserLogin(login, password);
			if (loggedUser!=null) {
				enableLoginPanel(false);
				return true;
			} else {
				generatePopupMassage("Incorrect login or password.\nTry again.", "Authorization error.",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
	}

	public void proceedLogout() {
		// TO DO: CONNECT AND MARGE
		System.out.println("logout");
		enableLoginPanel(true);
		loginField.setInsertedText("");
		passwordField.setInsertedText("");
	}

	private void enableLoginPanel(boolean enable) {
		loginButton.setEnabled(enable);
		logoutButton.setEnabled(!enable);
		loginField.setEnabled(enable);
		passwordField.setEnabled(enable);
	}

	private void generatePopupMassage(String massage, String title, int messageType) {

		JOptionPane.showMessageDialog(null, massage, title, messageType);
	}

	public void loadData() {
		// TODO Auto-generated method stub
	}

	public User getLoggedUser() {
		return loggedUser;
	}
}
