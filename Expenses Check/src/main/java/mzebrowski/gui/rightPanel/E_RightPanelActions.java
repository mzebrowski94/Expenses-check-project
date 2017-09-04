package mzebrowski.gui.rightPanel;

import mzebrowski.controller.Actions;

public enum E_RightPanelActions implements Actions {
	LOGIN, LOGOUT, OPTION_UPDATED, ADD_EXPENSE;
	
	public String actionName()
	{
		return toString();
	}
}
