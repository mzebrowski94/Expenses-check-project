package mzebrowski.gui.rightPanel.userInformationPanel;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.E_ExpenseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.services.ServiceManager;

public class UserInformationPanelController implements ControllerElement {

	ServiceManager serviceManager;
	UserInformationPanel userInformationPanel;
	JLabel ownExpenses, groupExpenses;
	
	public UserInformationPanelController(ServiceManager serviceManager, UserInformationPanel userInformationPanel) {
		this.serviceManager = serviceManager;
		this.userInformationPanel = userInformationPanel;
		this.ownExpenses = userInformationPanel.getOwnExpenses();
		this.groupExpenses = userInformationPanel.getGroupExpenses();
	}

	public void initListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
	}

	public void loadData() {
		updateUserInfo(null);
	}

	public void updateUserInfo(User user) {
		if(user!=null)
		{
			String ownExpensesRaport = serviceManager.getExpenseRaportForUser(user, E_ExpenseType.OWN);
			String groupExpensesRaport = serviceManager.getExpenseRaportForUser(user, E_ExpenseType.GROUP);
			ownExpenses.setText(ownExpensesRaport);
			groupExpenses.setText(groupExpensesRaport);
		}
		else
		{
			ownExpenses.setText(" - ");
			groupExpenses.setText(" - ");
		}
		
		
	}



}
