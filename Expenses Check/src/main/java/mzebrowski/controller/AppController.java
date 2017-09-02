package mzebrowski.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mzebrowski.gui.centerPanel.CenterPanelController;
import mzebrowski.gui.menuBar.MenuToolBarController;
import mzebrowski.gui.rightPanel.RightPanelController;

public class AppController implements ControllerElement, ActionListener {

	MenuToolBarController menuToolBarController;
	CenterPanelController centerPanelController;
	RightPanelController rightPanellController;
	
	public AppController(CenterPanelController centerPanelController, MenuToolBarController menuToolBarController, RightPanelController rightPanellController) {
		this.centerPanelController = centerPanelController;
		this.menuToolBarController = menuToolBarController;
		this.rightPanellController = rightPanellController;
	}

	public void loadData() {
		centerPanelController.loadData();
		rightPanellController.loadData();
	}

	public void initListeners(ActionListener actionListener) {
		centerPanelController.initListeners(this);
		rightPanellController.initListeners(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}
