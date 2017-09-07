package mzebrowski.gui.centerPanel.filterToolbar;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;

import mzebrowski.database.domain.enums.E_ExpenseType;
import mzebrowski.database.domain.enums.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.gui.GuiElement;
import mzebrowski.gui.additionalComponents.ComboBoxFilter;

@SuppressWarnings("serial")
public class ComboBoxesToolbar extends JToolBar implements GuiElement {

	ComboBoxFilter<User> userFilter;
	ComboBoxFilter<E_ExpenseType> expenseTypeFilter;
	ComboBoxFilter<E_PurchaseType> purchaseTypeFilter;
	JButton refreshButton;
	JButton deleteButton;

	public ComboBoxesToolbar(ComboBoxFilter<User> userFilter, ComboBoxFilter<E_ExpenseType> expenseTypeFilter,
			ComboBoxFilter<E_PurchaseType> purchaseTypeFilter, JButton refreshButton, JButton deleteButton) {
		this.userFilter = userFilter;
		this.expenseTypeFilter = expenseTypeFilter;
		this.purchaseTypeFilter = purchaseTypeFilter;
		this.refreshButton = refreshButton;
		this.deleteButton = deleteButton;
	}

	public void initLayout() {
		userFilter.initLayout();
		expenseTypeFilter.initLayout();
		purchaseTypeFilter.initLayout();
		
		setFloatable(false);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setMargin(new Insets(10, 5, 5, 5));

		add(userFilter);

		add(expenseTypeFilter);

		add(purchaseTypeFilter);

		add(refreshButton);

		add(deleteButton);
	}

	public ComboBoxFilter<User> getUserFilter() {
		return userFilter;
	}

	public ComboBoxFilter<E_ExpenseType> getExpenseTypeFilter() {
		return expenseTypeFilter;
	}

	public ComboBoxFilter<E_PurchaseType> getPurchaseTypeFilter() {
		return purchaseTypeFilter;
	}

	public JButton getRefreshButton() {
		return refreshButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}
	
	
}
