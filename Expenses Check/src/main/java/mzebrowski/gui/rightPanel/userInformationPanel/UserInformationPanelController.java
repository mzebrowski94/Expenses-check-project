package mzebrowski.gui.rightPanel.userInformationPanel;

import java.awt.event.ActionListener;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.services.ServiceManager;

public class UserInformationPanelController implements ControllerElement {

	ServiceManager serviceManager;
	UserInformationPanel userInformationPanel;
	
	public UserInformationPanelController(ServiceManager serviceManager, UserInformationPanel userInformationPanel) {
		this.serviceManager = serviceManager;
		this.userInformationPanel = userInformationPanel;
	}

	public void initListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
	}

	public void loadData() {
		// TODO Auto-generated method stub
	}

}
