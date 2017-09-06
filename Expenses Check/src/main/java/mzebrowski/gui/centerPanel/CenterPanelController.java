package mzebrowski.gui.centerPanel;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.E_ExpenseType;
import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.services.ServiceManager;
import mzebrowski.gui.centerPanel.filterToolbar.ComboBoxesToolbarController;
import mzebrowski.gui.centerPanel.raportPanel.RaportPanel;
import mzebrowski.gui.centerPanel.raportPanel.RaportPanelController;
import mzebrowski.gui.centerPanel.recordTable.RecordTableController;

public class CenterPanelController implements ControllerElement {

	ServiceManager serviceManager;
	private ComboBoxesToolbarController comboBoxesToolbarController;
	private RecordTableController recordTableController;
	private RaportPanelController raportPanelController;

	public CenterPanelController(ServiceManager serviceManager, RecordTableController recordTableController,
			ComboBoxesToolbarController comboBoxesToolbarController, RaportPanelController raportPanelController) {

		this.serviceManager = serviceManager;
		this.comboBoxesToolbarController = comboBoxesToolbarController;
		this.recordTableController = recordTableController;
		this.raportPanelController = raportPanelController;
	}

	public void loadData() {
		comboBoxesToolbarController.loadData();
		recordTableController.loadData();
		raportPanelController.loadData();
	}

	public void initListeners(ActionListener actionListener) {
		comboBoxesToolbarController.initListeners(actionListener);
		recordTableController.initListeners(actionListener);
	}

	public void updateRaport() {
		raportPanelController.updateRaportData();
	}

	public void updateRecordTable() {
		User user = comboBoxesToolbarController.getSelectedUser();
		E_ExpenseType expenseType = comboBoxesToolbarController.getSelectedExpenseType();
		E_PurchaseType purchaseType = comboBoxesToolbarController.getSelectedPurchaseType();
		recordTableController.updateTableData(user, expenseType, purchaseType);
	}
}
