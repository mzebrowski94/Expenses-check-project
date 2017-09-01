package mzebrowski.gui.rightPanel;


import java.awt.GridLayout;
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
import mzebrowski.database.domain.User;
import mzebrowski.gui.centerPanel.ComboBoxFilter;

@SuppressWarnings("serial")
public class ExpenseAddPanel extends JPanel {

	ComboBoxFilter<LocalDate> dateFilter;
	ComboBoxFilter<User> userFilter;
	ComboBoxFilter<E_PurchaseType> purchaseTypeFilter;
	ValueField valueField, discriptionField;
	JButton addButon;
	
	public ExpenseAddPanel(ComboBoxFilter<User> userFilter, ComboBoxFilter<E_PurchaseType> purchaseTypeFilter, ComboBoxFilter<LocalDate> dateFilter, ValueField valueField, JButton addButon, ValueField discriptionField) {

		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		setBorder(border);
		GridLayout layout = new GridLayout(3,2);
		setLayout(layout);

		this.userFilter = userFilter;
		userFilter.setBorder(border);
		add(userFilter);
		
		this.purchaseTypeFilter = purchaseTypeFilter;
		purchaseTypeFilter.setBorder(border);
		add(purchaseTypeFilter);
		
		this.discriptionField = discriptionField;
		discriptionField.setBorder(border);
		add(discriptionField);
		
		this.dateFilter = dateFilter;
		dateFilter.setBorder(border);
		add(dateFilter);
		
		this.valueField = valueField;
		add(valueField);
		
		this.addButon = addButon;
		addButon.setToolTipText("Add expense");
		add(addButon);
		
	}

	public void loadData(ArrayList<User> users) {
		updateDateCBFilter();
		updateUserCBFilter(users);
		updatePurchaseTypeCBFilter();
	}
	
	private void updateDateCBFilter()
	{			
		dateFilter.setOptionListData(getLastWeekDays());
	}
	
	private void updateUserCBFilter(ArrayList<User> users)
	{
		userFilter.setOptionListData(users);
	}
	
	private void updatePurchaseTypeCBFilter()
	{
		purchaseTypeFilter.setOptionListData(new ArrayList<E_PurchaseType>(Arrays.asList(E_PurchaseType.values())));
	}
	
	private ArrayList<LocalDate> getLastWeekDays()
	{
		LocalDate start = LocalDate.now();
		LocalDate end = LocalDate.now().minusWeeks(1);
		ArrayList<LocalDate> totalDates = new ArrayList<LocalDate>();
		while (start.isAfter(end)) {
		    totalDates.add(start);
		    start = start.minusDays(1);
		}	
		return totalDates;
	}
}
