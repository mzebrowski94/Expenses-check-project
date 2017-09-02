package mzebrowski.controller;

import java.awt.event.ActionListener;

public interface ControllerElement {
	
	public void initListeners(ActionListener actionListener);
	public void loadData();
}
