package mzebrowski.gui.rightPanel;

import java.util.ArrayList;

import mzebrowski.database.DAOManager;
import mzebrowski.database.DAOs.ExpenseDAO;
import mzebrowski.database.DAOs.UserDAO;
import mzebrowski.database.domain.User;

public class RightPanelController {

	DAOManager daoManager;
	RightPanel rightPanel;
	UserLoginPanel userLoginPanel;
	UserInformationPanel userInformationPanel;
	ExpenseAddPanel addExpensePanel;
	private ExpenseDAO expenseDAO;
	private UserDAO userDAO;
	
	public RightPanelController(DAOManager daoManager, RightPanel rightPanel) {
		this.daoManager = daoManager;
		this.expenseDAO = daoManager.getExpenseDAO();
		this.userDAO = daoManager.getUserDAO();
		this.rightPanel = rightPanel;
		this.userLoginPanel = rightPanel.getUserAvatarPanel();
		this.userInformationPanel = rightPanel.getUserInformationPanel();
		this.addExpensePanel = rightPanel.getAddExpensePanel();
	}

	public void loadData() {
		addExpensePanel.loadData((ArrayList<User>) userDAO.getAll());
	}
}
