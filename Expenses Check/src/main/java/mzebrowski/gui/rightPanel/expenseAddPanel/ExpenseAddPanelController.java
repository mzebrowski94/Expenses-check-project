package mzebrowski.gui.rightPanel.expenseAddPanel;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.E_ExpenseType;
import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.expense.Expense;
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
	ComboBoxFilter<E_ExpenseType> expenseTypeFilter;
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
		this.expenseTypeFilter = addExpensePanel.getExpenseTypeFilter();
	}

	public void initListeners(ActionListener actionListener) {
		addExpensePanel.initActionsAndListeners(actionListener);
	}

	public void loadData() {
		dateFilter.setOptionListData(getLastWeekDays());
		userFilter.setOptionListData((ArrayList<User>) serviceManager.getAllUsers());
		purchaseTypeFilter.setOptionListData(new ArrayList<E_PurchaseType>(Arrays.asList(E_PurchaseType.values())));
		expenseTypeFilter.setOptionListData(new ArrayList<E_ExpenseType>(Arrays.asList(E_ExpenseType.values())));
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

	public void setAddingEnabled(boolean enable) {
		addExpensePanel.setAddingEnabled(enable);
	}

	public boolean addExpenseToDB() {

		Expense expense = createExpenseFromOptionList();
		if (expense != null) {
			serviceManager.addNewRecord(expense);
			return true;
		} else
			return false;

	}

	private Expense createExpenseFromOptionList() throws IllegalArgumentException {
		try {
			Expense expense = new Expense();

			String amountText = valueField.getInsertedText().replace(",", ".");
			double amount = Double.parseDouble(amountText);

			LocalDate localdate = (LocalDate) dateFilter.getSelectedItem();
			Date date = Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant());

			String discription = discriptionField.getInsertedText();
			if (discription.equals(""))
				discription = "No discription";

			expense.setAmount(amount);
			expense.setDate(date);
			expense.setDiscription(discription);
			expense.setExpenseType((E_ExpenseType) expenseTypeFilter.getSelectedItem());
			expense.setPurchaseType((E_PurchaseType) purchaseTypeFilter.getSelectedItem());
			expense.setUser((User) userFilter.getSelectedItem());
			System.out.println(expense.toString());
			return expense;
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Incorrect number or discription.\nTry again.",
					"Incorrect number or discription.", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
