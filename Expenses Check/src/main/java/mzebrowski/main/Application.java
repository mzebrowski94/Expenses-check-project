package mzebrowski.main;

import mzebrowski.controller.AppController;
import mzebrowski.controller.AppControllerFactory;
import mzebrowski.database.ConnectionFactory;
import mzebrowski.database.DAOManager;
import mzebrowski.gui.MainWindow;
import mzebrowski.gui.MainWindowFactory;

public class Application {

	private DAOManager DAOManager;
	private MainWindow mainWindow;
	private AppController appController;
	
	public Application() {
		
		//Model Layer
		DAOManager = new DAOManager(new ConnectionFactory().openDefaultConnection());
		
		//View Layer
		mainWindow = new MainWindowFactory().build();
		
		//Presentation - Controller Layer
		appController = new AppControllerFactory().build(mainWindow, DAOManager); 
	}
	
	public void loadData()
	{
		appController.loadDataToView();
	}
}
