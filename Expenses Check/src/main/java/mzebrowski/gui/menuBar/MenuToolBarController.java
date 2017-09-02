package mzebrowski.gui.menuBar;

import mzebrowski.database.services.ServiceManager;

public class MenuToolBarController {

	ServiceManager serviceManager;
	MenuToolBar menuToolBar;
	
	public MenuToolBarController(ServiceManager serviceManager, MenuToolBar menuToolBar) {
		this.serviceManager = serviceManager;
		this.menuToolBar = menuToolBar;
	}
}
