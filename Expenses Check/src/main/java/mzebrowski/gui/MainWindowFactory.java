package mzebrowski.gui;

import mzebrowski.gui.centerPanel.CenterPanelFactory;
import mzebrowski.gui.menuBar.MenuBar;
import mzebrowski.gui.rightPanel.RightPanelFactory;

public class MainWindowFactory {
	
	public MainWindow build()
	{
		MainWindow mainWindow = new MainWindow(
				new MenuBar(),
				new CenterPanelFactory().build(),
				new RightPanelFactory().build()
				);
		
		return mainWindow;	
	}
}
