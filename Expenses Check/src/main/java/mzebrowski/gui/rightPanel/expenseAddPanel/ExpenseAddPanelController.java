package mzebrowski.gui.rightPanel.expenseAddPanel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.services.ServiceManager;
import mzebrowski.gui.centerPanel.ComboBoxFilter;
import mzebrowski.gui.rightPanel.ValueField;

public class ExpenseAddPanelController implements ControllerElement {

	ServiceManager serviceManager;
	ExpenseAddPanel addExpensePanel;
	ComboBoxFilter<LocalDate> dateFilter;
	ComboBoxFilter<User> userFilter;
	ComboBoxFilter<E_PurchaseType> purchaseTypeFilter;
	ValueField valueField, discriptionField;
	JButton addButon;
	
	public ExpenseAddPanelController(ServiceManager serviceManager, ExpenseAddPanel addExpensePanel) {
		this.serviceManager = serviceManager;
		this.addExpensePanel = addExpensePanel;
		this.dateFilter = addExpensePanel.getDateFilter();
		this.userFilter = addExpensePanel.getUserFilter();
		this.purchaseTypeFilter = addExpensePanel.getPurchaseTypeFilter();
		this.valueField = addExpensePanel.getValueField();
		this.discriptionField = addExpensePanel.getDiscriptionField();
		this.addButon = addExpensePanel.getAddButon();
	}

	public void initListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
	}

	public void loadData() {
		dateFilter.setOptionListData(getLastWeekDays());
		userFilter.setOptionListData((ArrayList<User>) serviceManager.getAllUsers());
		purchaseTypeFilter.setOptionListData(new ArrayList<E_PurchaseType>(Arrays.asList(E_PurchaseType.values())));
	}
	
	private ArrayList<LocalDate> getLastWeekDays() {
		LocalDate start = LocalDate.now();
		LocalDate end = LocalDate.now().minusWeeks(1);
		ArrayList<LocalDate> totalDates = new ArrayList<LocalDate>();
		while (start.isAfter(end)) {
			totalDates.add(start);
			start = start.minusDays(1);
		}
		return totalDates;
	}
	
	public void setAddingEnabled(boolean enable)
	{
		addExpensePanel.setAddingEnabled(enable);
	}

}
