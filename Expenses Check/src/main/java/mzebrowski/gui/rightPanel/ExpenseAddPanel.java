package mzebrowski.gui.rightPanel;

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

import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.gui.GuiElement;
import mzebrowski.gui.centerPanel.ComboBoxFilter;

@SuppressWarnings("serial")
public class ExpenseAddPanel extends JPanel implements GuiElement {

	ComboBoxFilter<LocalDate> dateFilter;
	ComboBoxFilter<User> userFilter;
	ComboBoxFilter<E_PurchaseType> purchaseTypeFilter;
	ValueField valueField, discriptionField;
	JButton addButon;

	public ExpenseAddPanel(ComboBoxFilter<User> userFilter, ComboBoxFilter<E_PurchaseType> purchaseTypeFilter,
			ComboBoxFilter<LocalDate> dateFilter, ValueField valueField, JButton addButon,
			ValueField discriptionField) {
		this.userFilter = userFilter;
		this.purchaseTypeFilter = purchaseTypeFilter;
		this.discriptionField = discriptionField;
		this.dateFilter = dateFilter;
		this.addButon = addButon;
		this.valueField = valueField;
	}

	public void loadData(ArrayList<User> users) {
		updateDateCBFilter();
		updateUserCBFilter(users);
		updatePurchaseTypeCBFilter();
	}

	private void updateDateCBFilter() {
		dateFilter.setOptionListData(getLastWeekDays());
	}

	private void updateUserCBFilter(ArrayList<User> users) {
		userFilter.setOptionListData(users);
	}

	private void updatePurchaseTypeCBFilter() {
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

	public void initLayout() {
		this.valueField.initLayout();
		this.discriptionField.initLayout();
		this.userFilter.initLayout();
		this.purchaseTypeFilter.initLayout();
		this.dateFilter.initLayout();
		
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		setBorder(border);
		GridLayout layout = new GridLayout(3, 2);
		setLayout(layout);

		userFilter.setBorder(border);
		add(userFilter);

		purchaseTypeFilter.setBorder(border);
		add(purchaseTypeFilter);

		discriptionField.setBorder(border);
		add(discriptionField);

		dateFilter.setBorder(border);
		add(dateFilter);

		add(valueField);

		addButon.setToolTipText("Add expense");
		add(addButon);
		setAddingEnabled(false);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		this.userFilter.initActionsAndListeners(actionListener);
		this.purchaseTypeFilter.initActionsAndListeners(actionListener);
		this.discriptionField.initActionsAndListeners(actionListener);
		this.dateFilter.initActionsAndListeners(actionListener);
		this.addButon.addActionListener(actionListener);
		this.valueField.initActionsAndListeners(actionListener);	
	}
	
	public void setAddingEnabled(boolean enable)
	{
		this.userFilter.setChoosingEnabled(enable);
		this.purchaseTypeFilter.setChoosingEnabled(enable);
		this.discriptionField.setTypingEnabled(enable);
		this.dateFilter.setChoosingEnabled(enable);
		this.addButon.setEnabled(enable);
		this.valueField.setTypingEnabled(enable);
	}
}
