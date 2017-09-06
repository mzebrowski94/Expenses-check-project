package mzebrowski.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mzebrowski.gui.centerPanel.CenterPanelController;
import mzebrowski.gui.menuBar.MenuToolBarController;
import mzebrowski.gui.rightPanel.E_RightPanelActions;
import mzebrowski.gui.rightPanel.RightPanelController;

public class AppController implements ControllerElement, ActionListener {

	MenuToolBarController menuToolBarController;
	CenterPanelController centerPanelController;
	RightPanelController rightPanelController;

	public AppController(CenterPanelController centerPanelController, MenuToolBarController menuToolBarController,
			RightPanelController rightPanellController) {
		this.centerPanelController = centerPanelController;
		this.menuToolBarController = menuToolBarController;
		this.rightPanelController = rightPanellController;
	}

	public void loadData() {
		centerPanelController.loadData();
		rightPanelController.loadData();
	}

	public void initListeners(ActionListener actionListener) {
		centerPanelController.initListeners(this);
		rightPanelController.initListeners(this);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == E_RightPanelActions.LOGIN.actionName()) {
			rightPanelController.proceedLogin();
		} else if (event.getActionCommand() == E_RightPanelActions.LOGOUT.actionName()) {
			rightPanelController.proceedLogout();
		} else if (event.getActionCommand() == E_RightPanelActions.ADD_EXPENSE.actionName()) {
			if (rightPanelController.addExpense())
				centerPanelController.updateRaport();
		} else if (event.getActionCommand() == E_RightPanelActions.FILTER_CHANGED.actionName()) {
			centerPanelController.updateRaport();
			centerPanelController.updateRecordTable();
		}
	}
}
