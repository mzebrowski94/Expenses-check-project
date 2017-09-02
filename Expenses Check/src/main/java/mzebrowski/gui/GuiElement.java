package mzebrowski.gui;

import java.awt.event.ActionListener;

public interface GuiElement {
	
	public void initLayout();
	public void initActionsAndListeners(ActionListener actionListener);
}
