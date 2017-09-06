package mzebrowski.gui.rightPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.services.ServiceManager;
import mzebrowski.gui.rightPanel.expenseAddPanel.ExpenseAddPanelController;
import mzebrowski.gui.rightPanel.userInformationPanel.UserInformationPanelController;
import mzebrowski.gui.rightPanel.userLoginPanel.UserLoginPanelController;

public class RightPanelController implements ControllerElement {

	ServiceManager serviceManager;
	UserLoginPanelController userLoginPanelController;
	UserInformationPanelController userInformationPanelController;
	ExpenseAddPanelController expenseAddPanelController;

	public RightPanelController(ServiceManager serviceManager,
			UserLoginPanelController userLoginPanelController,
			UserInformationPanelController userInformationPanelController,
			ExpenseAddPanelController expenseAddPanelController) {
		this.serviceManager = serviceManager;
		this.userLoginPanelController = userLoginPanelController;
		this.userInformationPanelController = userInformationPanelController;
		this.expenseAddPanelController = expenseAddPanelController;
	}

	public void initListeners(ActionListener actionListener) {
		userLoginPanelController.initListeners(actionListener);
		userInformationPanelController.initListeners(actionListener);
		expenseAddPanelController.initListeners(actionListener);
	}

	public void loadData() {
		expenseAddPanelController.loadData();
		userInformationPanelController.loadData();
	}

	public boolean addExpense() {
		if (expenseAddPanelController.addExpenseToDB())
		{
			User user = userLoginPanelController.getLoggedUser();
			userInformationPanelController.updateUserInfo(user);
			return true;
		}
			
		else
			return false;
	}

	public boolean proceedLogin() {
		if (userLoginPanelController.proceedLogin()) {
			expenseAddPanelController.setAddingEnabled(true);
			User user = userLoginPanelController.getLoggedUser();
			userInformationPanelController.updateUserInfo(user);
			return true;
		} else
			return false;
	}

	public void proceedLogout() {
		userLoginPanelController.proceedLogout();
		expenseAddPanelController.setAddingEnabled(false);
		userInformationPanelController.updateUserInfo(null);
	}
}
