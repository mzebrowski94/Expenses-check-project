package mzebrowski.controller;

import mzebrowski.database.services.ServiceManager;
import mzebrowski.gui.MainWindow;
import mzebrowski.gui.centerPanel.CenterPanel;
import mzebrowski.gui.centerPanel.CenterPanelController;
import mzebrowski.gui.menuBar.MenuToolBarController;
import mzebrowski.gui.rightPanel.RightPanel;
import mzebrowski.gui.rightPanel.RightPanelController;
import mzebrowski.gui.rightPanel.expenseAddPanel.ExpenseAddPanelController;
import mzebrowski.gui.rightPanel.userInformationPanel.UserInformationPanelController;
import mzebrowski.gui.rightPanel.userLoginPanel.UserLoginPanelController;

public class AppControllerFactory {

	public AppController build(MainWindow mainWindow, ServiceManager serviceManager) {
		AppController appController;
		CenterPanel centerPanel = mainWindow.getCenterPanel();
		RightPanel rightPanel = mainWindow.getRightPanel();

		appController = new AppController(new CenterPanelController(serviceManager, centerPanel),
				new MenuToolBarController(serviceManager, mainWindow.getMenuToolBar()),
				new RightPanelController(serviceManager, rightPanel,
						new UserLoginPanelController(serviceManager, rightPanel.getUserAvatarPanel()),
						new UserInformationPanelController(serviceManager, rightPanel.getUserInformationPanel()),
						new ExpenseAddPanelController(serviceManager, rightPanel.getAddExpensePanel())));
		return appController;
	}
}
