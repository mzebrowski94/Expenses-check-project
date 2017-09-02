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

import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.gui.GuiElement;
import mzebrowski.gui.centerPanel.ComboBoxFilter;
import mzebrowski.gui.rightPanel.ValueField;

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
	
}
