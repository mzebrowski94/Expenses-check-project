package mzebrowski.main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import mzebrowski.gui.MainWindow;
import mzebrowski.gui.MainWindowFactory;

public class ApplicationFactory {

	public ApplicationFactory() {
		
		setLookAndFeel();
		MainWindow mainWindow = new MainWindowFactory().build();
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

