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
	RightPanel rightPanel;
	UserLoginPanelController userLoginPanelController;
	UserInformationPanelController userInformationPanelController;
	ExpenseAddPanelController expenseAddPanelController;

	public RightPanelController(ServiceManager serviceManager, RightPanel rightPanel,
			UserLoginPanelController userLoginPanelController,
			UserInformationPanelController userInformationPanelController,
			ExpenseAddPanelController expenseAddPanelController) {
		this.serviceManager = serviceManager;
		this.rightPanel = rightPanel;
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
	}

	public boolean addExpense() {
		if(expenseAddPanelController.addExpenseToDB())
			return true;
		else
			return false;
	}

	public void proceedLogin() {
		if (userLoginPanelController.proceedLogin())
			expenseAddPanelController.setAddingEnabled(true);
	}

	public void proceedLogout() {
		userLoginPanelController.proceedLogout();
		expenseAddPanelController.setAddingEnabled(false);
	}
}
