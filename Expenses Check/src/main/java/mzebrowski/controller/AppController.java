package mzebrowski.controller;

import mzebrowski.gui.centerPanel.CenterPanelController;
import mzebrowski.gui.menuBar.MenuToolBarController;
import mzebrowski.gui.rightPanel.RightPanelController;

public class AppController {

	MenuToolBarController menuToolBarController;
	CenterPanelController centerPanelController;
	RightPanelController rightPanellController;
	
	public AppController(CenterPanelController centerPanelController, MenuToolBarController menuToolBarController, RightPanelController rightPanellController) {
		this.centerPanelController = centerPanelController;
		this.menuToolBarController = menuToolBarController;
		this.rightPanellController = rightPanellController;
	}

	public void loadDataToView() {
		centerPanelController.loadData();
		rightPanellController.loadData();
	}
}
