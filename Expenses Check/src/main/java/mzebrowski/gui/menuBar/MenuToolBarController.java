package mzebrowski.gui.menuBar;

import mzebrowski.database.DAOManager;

public class MenuToolBarController {

	DAOManager daoManager;
	MenuToolBar menuToolBar;
	
	public MenuToolBarController(DAOManager daoManager, MenuToolBar menuToolBar) {
		this.daoManager = daoManager;
		this.menuToolBar = menuToolBar;
	}
}
