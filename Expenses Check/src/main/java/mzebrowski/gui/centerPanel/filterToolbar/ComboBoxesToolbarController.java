package mzebrowski.gui.centerPanel.filterToolbar;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.enums.E_ExpenseType;
import mzebrowski.database.domain.enums.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.database.services.ServiceManager;
import mzebrowski.gui.additionalComponents.ComboBoxFilter;
import mzebrowski.gui.rightPanel.E_RightPanelActions;

public class ComboBoxesToolbarController implements ControllerElement {
	
	ServiceManager serviceManager; 
	ComboBoxesToolbar comboBoxesToolbar;
	ComboBoxFilter<User> userFilter;
	ComboBoxFilter<E_ExpenseType> expenseTypeFilter;
	ComboBoxFilter<E_PurchaseType> purchaseTypeFilter;
	JButton refreshButton;
	JButton minusButton;
	
	public ComboBoxesToolbarController(ServiceManager serviceManager, ComboBoxesToolbar comboBoxesToolbar) {
		this.serviceManager = serviceManager;
		this.comboBoxesToolbar = comboBoxesToolbar;
		this.userFilter = comboBoxesToolbar.getUserFilter();
		this.expenseTypeFilter  = comboBoxesToolbar.getExpenseTypeFilter();
		this.purchaseTypeFilter  = comboBoxesToolbar.getPurchaseTypeFilter();
		this.refreshButton  = comboBoxesToolbar.getRefreshButton();
		this.minusButton  = comboBoxesToolbar.getDeleteButton();
	}
	
	public void initListeners(ActionListener actionListener) {
		this.userFilter.initActionsAndListeners(actionListener);
		this.expenseTypeFilter.initActionsAndListeners(actionListener);
		this.purchaseTypeFilter.initActionsAndListeners(actionListener);

		refreshButton.setActionCommand(E_RightPanelActions.REFRESH_DATA.actionName());
		this.refreshButton.addActionListener(actionListener);

		minusButton.setActionCommand(E_RightPanelActions.DELETE_RECORD.actionName());
		this.minusButton.addActionListener(actionListener);
	}

	public void loadData() {
		userFilter.setOptionListData((ArrayList<User>) serviceManager.getAllUsers());
		expenseTypeFilter.setOptionListData(new ArrayList<E_ExpenseType>(Arrays.asList(E_ExpenseType.values())));
		purchaseTypeFilter.setOptionListData(new ArrayList<E_PurchaseType>(Arrays.asList(E_PurchaseType.values())));
	}
	
	public User getSelectedUser()
	{
		return (User) userFilter.getSelectedItem();
	}
	
	public E_ExpenseType getSelectedExpenseType()
	{
		return (E_ExpenseType) expenseTypeFilter.getSelectedItem();
	}
	public E_PurchaseType getSelectedPurchaseType()
	{
		return (E_PurchaseType) purchaseTypeFilter.getSelectedItem();
	}
}
