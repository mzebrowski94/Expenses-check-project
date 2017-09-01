package mzebrowski.controller;

import mzebrowski.database.DAOManager;
import mzebrowski.gui.MainWindow;
import mzebrowski.gui.centerPanel.CenterPanelController;
import mzebrowski.gui.menuBar.MenuToolBarController;
import mzebrowski.gui.rightPanel.RightPanelController;

public class AppControllerFactory {
	
	
	public AppController build(MainWindow mainWindow, DAOManager daoManager)
	{
		AppController appController;
		
		appController = new AppController(
				new CenterPanelController(daoManager, mainWindow.getCenterPanel()),
				new MenuToolBarController(daoManager, mainWindow.getMenuToolBar()),
				new RightPanelController(daoManager, mainWindow.getRightPanel())
				);
		return appController;
	}
}
