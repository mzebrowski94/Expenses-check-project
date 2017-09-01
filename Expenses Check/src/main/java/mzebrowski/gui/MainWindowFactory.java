package mzebrowski.gui;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import mzebrowski.gui.centerPanel.CenterPanelFactory;
import mzebrowski.gui.menuBar.MenuToolBar;
import mzebrowski.gui.rightPanel.RightPanelFactory;

public class MainWindowFactory {
	
	public MainWindow build()
	{
		setLookAndFeel();
		
		MainWindow mainWindow = new MainWindow(
				new MenuToolBar(),
				new CenterPanelFactory().build(),
				new RightPanelFactory().build()
				);
		
		return mainWindow;	
	}
	
	private void setLookAndFeel()
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel(
				        UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception e1) {
				//TO DO:
			}
		}
	}
}
