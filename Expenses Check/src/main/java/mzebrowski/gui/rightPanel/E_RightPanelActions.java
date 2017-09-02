package mzebrowski.gui.rightPanel;

import mzebrowski.controller.Actions;

public enum E_RightPanelActions implements Actions {
	LOGIN, LOGOUT;
	
	public String actionName()
	{
		return toString();
	}
}
