package mzebrowski.controller;

import mzebrowski.database.DAOManager;
import mzebrowski.database.services.ServiceManager;
import mzebrowski.gui.MainWindow;
import mzebrowski.gui.centerPanel.CenterPanelController;
import mzebrowski.gui.menuBar.MenuToolBarController;
import mzebrowski.gui.rightPanel.RightPanelController;

public class AppControllerFactory {
	
	
	public AppController build(MainWindow mainWindow, ServiceManager serviceManager)
	{
		AppController appController;
		
		appController = new AppController(
				new CenterPanelController(serviceManager, mainWindow.getCenterPanel()),
				new MenuToolBarController(serviceManager, mainWindow.getMenuToolBar()),
				new RightPanelController(serviceManager, mainWindow.getRightPanel())
				);
		return appController;
	}
}
