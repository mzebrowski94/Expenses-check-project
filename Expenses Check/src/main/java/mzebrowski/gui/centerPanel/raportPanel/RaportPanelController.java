package mzebrowski.gui.centerPanel.raportPanel;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JTextPane;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.enums.E_ExpenseType;
import mzebrowski.database.domain.enums.E_PurchaseType;
import mzebrowski.database.domain.expense.Expense;
import mzebrowski.database.domain.wrappers.UserSumExpensesWrapper;
import mzebrowski.database.services.ServiceManager;

public class RaportPanelController implements ControllerElement {

	RaportPanel raportPanel;
	ServiceManager serviceManager;
	JTextPane groupMonthRaport;
	JTextPane groupAllTimeRaport;
	JTextPane purchaseTypeRaport;
	JLabel connectionStatus;

	public RaportPanelController(ServiceManager serviceManager, RaportPanel raportPanel) {
		this.serviceManager = serviceManager;
		this.raportPanel = raportPanel;
		this.groupMonthRaport = raportPanel.getGroupMonthRaport();
		this.groupAllTimeRaport = raportPanel.getGroupAllTimeRaport();
		this.purchaseTypeRaport = raportPanel.getPurchaseTypeRaport();
		this.connectionStatus = raportPanel.getConnectionStatus();
	}

	public void initListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
	}

	public void loadData() {
		updateRaportData();
		updateConnectionStatus();
	}

	public void updateRaportData() {
		updateGroupMonthRaport();
		updateGroupAllTimeRaport();
		updatePurchaseTypeRaport();
	}

	private void updatePurchaseTypeRaport() {
		LocalDate startDate = LocalDate.now();
		startDate = startDate.withDayOfMonth(1);
		LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
		
		String raportStr = "Group expenses this month: \n";
		
		List<Expense> raport = serviceManager.getExpensesFiltered(null, E_ExpenseType.GROUP, null);
		ArrayList<E_PurchaseType> purchaseTypes = new ArrayList<E_PurchaseType>(Arrays.asList(E_PurchaseType.values()));
		//ArrayList<String> purchaseTypes 
		
		Map<E_PurchaseType, Integer> purchaseValues = new HashMap<E_PurchaseType, Integer>();
		
		for(E_PurchaseType type : purchaseTypes)
			purchaseValues.put(type,0);
		
		
		for (Expense expense : raport)
		{
			int actualVal = purchaseValues.get(expense.getPurchaseType());
			purchaseValues.put(expense.getPurchaseType(), (int) (actualVal + expense.getAmount()));			
		}
		
		for (Entry<E_PurchaseType, Integer> entry : purchaseValues.entrySet())
		    raportStr += entry.getKey().toString() + ":  " + entry.getValue() + "\n";
		
		purchaseTypeRaport.setText(raportStr);
	}

	private void updateGroupMonthRaport() {
		LocalDate startDate = LocalDate.now();
		startDate = startDate.withDayOfMonth(1);
		LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
		
		String raportStr = "Amount spent this month: \n";
		groupMonthRaport.setText(printRaport(raportStr, startDate, endDate));
	}

	private void updateGroupAllTimeRaport() {
		LocalDate startDate = LocalDate.now().minusYears(100);
		String raportStr = "Amount spent at all time: \n";
		
		groupAllTimeRaport.setText(printRaport(raportStr, startDate, LocalDate.now()));
	}

	private String printRaport(String title, LocalDate startDate, LocalDate endDate) {

		Double avarage = serviceManager.getAverageUsersExpensesBetween(E_ExpenseType.GROUP, startDate, endDate);
		avarage = setDoublePrecision(avarage,1);
		List<UserSumExpensesWrapper> raport = serviceManager.getUsersExpensesRaportBetween(E_ExpenseType.GROUP,
				startDate, endDate);

		title += "Average: " + avarage + " per user \n";
		for (UserSumExpensesWrapper itr : raport) {
			title += itr.getUser().toString() + " " + itr.getSumedExpenses().toString() + "    ("
					+ setDoublePrecision(avarage - itr.getSumedExpenses(), 1) + " to average)" + "\n";
		}
		return title;
	}

	private double setDoublePrecision(double number, int precision) {
		return BigDecimal.valueOf(number).setScale(precision, RoundingMode.HALF_UP).doubleValue();
	}

	public void updateConnectionStatus() {

	}

}
