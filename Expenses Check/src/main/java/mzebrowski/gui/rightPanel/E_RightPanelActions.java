package mzebrowski.gui.rightPanel;

import mzebrowski.controller.Actions;

public enum E_RightPanelActions implements Actions {
	LOGIN, LOGOUT, ADD_EXPENSE, FILTER_CHANGED, REFRESH_DATA, DELETE_RECORD;
	
	public String actionName()
	{
		return toString();
	}
}
