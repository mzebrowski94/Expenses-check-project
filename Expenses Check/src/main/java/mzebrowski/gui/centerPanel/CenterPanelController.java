package mzebrowski.gui.centerPanel;

import java.util.ArrayList;

import mzebrowski.database.DAOManager;
import mzebrowski.database.DAOs.ExpenseDAO;
import mzebrowski.database.DAOs.UserDAO;
import mzebrowski.database.domain.Expense;
import mzebrowski.database.domain.User;

public class CenterPanelController {

	private DAOManager daoManager;
	private CenterPanel centerPanel;
	private ComboBoxesToolbar comboBoxesToolbar;
	private RecordTable recordTable;
	private RaportPanel raportPanel;
	private ExpenseDAO expenseDAO;
	private UserDAO userDAO;
	
	public CenterPanelController(DAOManager daoManager, CenterPanel centerPanel) {
		
		this.daoManager = daoManager;
		this.expenseDAO = daoManager.getExpenseDAO();
		this.userDAO = daoManager.getUserDAO();
		this.centerPanel = centerPanel;
		this.comboBoxesToolbar = centerPanel.getComboBoxesToolbar();
		this.recordTable = centerPanel.getRecordTable();
		this.raportPanel = centerPanel.getStatusbar();
	}

	public void loadData() {
		comboBoxesToolbar.loadData((ArrayList<User>) userDAO.getAll());	
		recordTable.updateRecordTableData((ArrayList<Expense>) expenseDAO.getAll());
		raportPanel.updateData("raport");
		
	}
}
