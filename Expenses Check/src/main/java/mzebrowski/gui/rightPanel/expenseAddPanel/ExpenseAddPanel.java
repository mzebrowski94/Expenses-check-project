package mzebrowski.gui.rightPanel.expenseAddPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import mzebrowski.database.domain.E_ExpenseType;
import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.gui.GuiElement;
import mzebrowski.gui.centerPanel.ComboBoxFilter;
import mzebrowski.gui.rightPanel.E_RightPanelActions;
import mzebrowski.gui.rightPanel.ValueField;

@SuppressWarnings("serial")
public class ExpenseAddPanel extends JPanel implements GuiElement {

	ComboBoxFilter<LocalDate> dateFilter;
	ComboBoxFilter<User> userFilter;
	ComboBoxFilter<E_PurchaseType> purchaseTypeFilter;
	ComboBoxFilter<E_ExpenseType> expenseTypeFilter;
	ValueField valueField, discriptionField;
	JButton addButon;

	public ExpenseAddPanel(ComboBoxFilter<User> userFilter, ComboBoxFilter<E_PurchaseType> purchaseTypeFilter,
			ComboBoxFilter<LocalDate> dateFilter, ComboBoxFilter<E_ExpenseType> expenseTypeFilter,
			ValueField valueField, JButton addButon, ValueField discriptionField) {
		this.userFilter = userFilter;
		this.purchaseTypeFilter = purchaseTypeFilter;
		this.expenseTypeFilter = expenseTypeFilter;
		this.discriptionField = discriptionField;
		this.dateFilter = dateFilter;
		this.addButon = addButon;
		this.valueField = valueField;
	}

	public void initLayout() {
		this.valueField.initLayout();
		this.discriptionField.initLayout();
		this.userFilter.initLayout();
		this.purchaseTypeFilter.initLayout();
		this.dateFilter.initLayout();
		this.expenseTypeFilter.initLayout();

		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		setBorder(border);
		GridLayout layout = new GridLayout(4, 2);
		setLayout(layout);

		userFilter.setBorder(border);
		add(userFilter);

		dateFilter.setBorder(border);
		add(dateFilter);

		purchaseTypeFilter.setBorder(border);
		add(purchaseTypeFilter);

		expenseTypeFilter.setBorder(border);
		add(expenseTypeFilter);

		discriptionField.setBorder(border);
		add(discriptionField);

		add(valueField);

		addButon.setToolTipText("Add expense");
		add(addButon);
		setAddingEnabled(false);
	}

	public void initActionsAndListeners(ActionListener actionListener) {

		userFilter.setActionCommandForComboBox(E_RightPanelActions.OPTION_UPDATED.actionName());
		this.userFilter.initActionsAndListeners(actionListener);

		purchaseTypeFilter.setActionCommandForComboBox(E_RightPanelActions.OPTION_UPDATED.actionName());
		this.purchaseTypeFilter.initActionsAndListeners(actionListener);

		discriptionField.setActionCommandForTextValue(E_RightPanelActions.OPTION_UPDATED.actionName());
		this.discriptionField.initActionsAndListeners(actionListener);

		dateFilter.setActionCommandForComboBox(E_RightPanelActions.OPTION_UPDATED.actionName());
		this.dateFilter.initActionsAndListeners(actionListener);

		expenseTypeFilter.setActionCommandForComboBox(E_RightPanelActions.OPTION_UPDATED.actionName());
		this.expenseTypeFilter.initActionsAndListeners(actionListener);

		addButon.setActionCommand(E_RightPanelActions.ADD_EXPENSE.actionName());
		this.addButon.addActionListener(actionListener);

		valueField.setActionCommandForTextValue(E_RightPanelActions.OPTION_UPDATED.actionName());
		this.valueField.initActionsAndListeners(actionListener);
	}

	public void setAddingEnabled(boolean enable) {
		this.userFilter.setChoosingEnabled(enable);
		this.purchaseTypeFilter.setChoosingEnabled(enable);
		this.discriptionField.setTypingEnabled(enable);
		this.dateFilter.setChoosingEnabled(enable);
		this.addButon.setEnabled(enable);
		this.valueField.setTypingEnabled(enable);
		this.expenseTypeFilter.setChoosingEnabled(enable);
	}

	public ComboBoxFilter<LocalDate> getDateFilter() {
		return dateFilter;
	}

	public ComboBoxFilter<User> getUserFilter() {
		return userFilter;
	}

	public ComboBoxFilter<E_PurchaseType> getPurchaseTypeFilter() {
		return purchaseTypeFilter;
	}

	public ValueField getValueField() {
		return valueField;
	}

	public ValueField getDiscriptionField() {
		return discriptionField;
	}

	public JButton getAddButon() {
		return addButon;
	}

	public ComboBoxFilter<E_ExpenseType> getExpenseTypeFilter() {
		return expenseTypeFilter;
	}

}
