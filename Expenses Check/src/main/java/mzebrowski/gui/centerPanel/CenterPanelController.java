package mzebrowski.gui.centerPanel;

import java.util.ArrayList;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.services.ServiceManager;

public class CenterPanelController implements ControllerElement {

	ServiceManager serviceManager;
	private CenterPanel centerPanel;
	private ComboBoxesToolbar comboBoxesToolbar;
	private RecordTable recordTable;
	private RaportPanel raportPanel;
	
	public CenterPanelController(ServiceManager serviceManager, CenterPanel centerPanel) {
		
		this.serviceManager = serviceManager;
		this.centerPanel = centerPanel;
		this.comboBoxesToolbar = centerPanel.getComboBoxesToolbar();
		this.recordTable = centerPanel.getRecordTable();
		this.raportPanel = centerPanel.getStatusbar();
	}

	public void loadData() {
		comboBoxesToolbar.loadData((ArrayList<User>) serviceManager.getAllUsers());	
		recordTable.updateRecordTableData((ArrayList<Expense>) serviceManager.getAllExpenses());
		raportPanel.updateData((ArrayList<String>) serviceManager.getUserExpensesRaport());
	}

	public void initListeners() {
		// TODO Auto-generated method stub		
	}
}