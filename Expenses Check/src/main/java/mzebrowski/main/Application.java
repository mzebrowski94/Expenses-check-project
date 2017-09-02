package mzebrowski.main;

import mzebrowski.controller.AppController;
import mzebrowski.controller.AppControllerFactory;
import mzebrowski.database.ConnectionFactory;
import mzebrowski.database.DAOManager;
import mzebrowski.database.services.ServiceManager;
import mzebrowski.gui.MainWindow;
import mzebrowski.gui.MainWindowFactory;

public class Application {

	private DAOManager daoManager;
	private ServiceManager serviceManager;
	private MainWindow mainWindow;
	private AppController appController;
	
	public Application() {
		
		//Model Layer
		daoManager = new DAOManager(new ConnectionFactory().openDefaultConnection());
		
		//Service Layer
		serviceManager = new ServiceManager(daoManager);
		
		//View Layer
		mainWindow = new MainWindowFactory().build();
		mainWindow.initLayout();
		
		//Presentation - Controller Layer
		appController = new AppControllerFactory().build(mainWindow, serviceManager);
		appController.initListeners(null);
		
	}
	
	public void loadData()
	{
		appController.loadData();
	}
}
