package mzebrowski.gui.centerPanel;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;

import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.gui.GuiElement;

@SuppressWarnings("serial")
public class ComboBoxesToolbar extends JToolBar implements GuiElement {

	ComboBoxFilter<User> userFilter;
	ComboBoxFilter<E_Incomes> incomeTypeFilter;
	ComboBoxFilter<E_PurchaseType> purchaseTypeFilter;
	JButton plusButton;
	JButton minusButton;

	public ComboBoxesToolbar(ComboBoxFilter<User> userFilter, ComboBoxFilter<E_Incomes> incomeTypeFilter,
			ComboBoxFilter<E_PurchaseType> purchaseTypeFilter, JButton plusButton, JButton minusButton) {
		this.userFilter = userFilter;
		this.incomeTypeFilter = incomeTypeFilter;
		this.purchaseTypeFilter = purchaseTypeFilter;
		this.plusButton = plusButton;
		this.minusButton = minusButton;
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

	public void initLayout() {
		userFilter.initLayout();
		incomeTypeFilter.initLayout();
		purchaseTypeFilter.initLayout();
		
		setFloatable(false);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setMargin(new Insets(10, 5, 5, 5));

		add(userFilter);

		add(incomeTypeFilter);

		add(purchaseTypeFilter);

		add(plusButton);

		add(minusButton);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		this.userFilter.initActionsAndListeners(actionListener);
		this.incomeTypeFilter.initActionsAndListeners(actionListener);
		this.purchaseTypeFilter.initActionsAndListeners(actionListener);
		this.plusButton.addActionListener(actionListener);
		this.minusButton.addActionListener(actionListener);
	}
}
