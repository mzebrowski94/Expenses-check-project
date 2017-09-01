package mzebrowski.gui.centerPanel;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;

import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.User;

@SuppressWarnings("serial")
public class ComboBoxesToolbar extends JToolBar {

	ComboBoxFilter<User> userFilter;
	ComboBoxFilter<E_Incomes> incomeTypeFilter;
	ComboBoxFilter<E_PurchaseType> purchaseTypeFilter;
	JButton plusButton;
	JButton minusButton;

	public ComboBoxesToolbar(ComboBoxFilter<User> userFilter, ComboBoxFilter<E_Incomes> incomeTypeFilter, ComboBoxFilter<E_PurchaseType> purchaseTypeFilter,
			JButton plusButton, JButton minusButton) {
		setFloatable(false);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setMargin(new Insets(10, 5, 5, 5));

		this.userFilter = userFilter;
		add(userFilter);
		this.incomeTypeFilter = incomeTypeFilter;

		add(incomeTypeFilter);

		this.purchaseTypeFilter = purchaseTypeFilter;
		add(purchaseTypeFilter);

		this.plusButton = plusButton;
		add(plusButton);

		this.minusButton = minusButton;
		add(minusButton);
	}

	public void updateUserCBFilter(ArrayList<User> users) {
		userFilter.setOptionListData(users);
	}

	public void updateIncomeTypeCBFilter() {
		incomeTypeFilter.setOptionListData(new ArrayList<E_Incomes>(Arrays.asList(E_Incomes.values())));
	}

	public void updatePurchaseTypeCBFilter() {
		purchaseTypeFilter.setOptionListData(new ArrayList<E_PurchaseType>(Arrays.asList(E_PurchaseType.values())));
	}

	public void loadData(ArrayList<User> users) {
		updateUserCBFilter(users);
		updateIncomeTypeCBFilter();
		updatePurchaseTypeCBFilter();
	}
}
