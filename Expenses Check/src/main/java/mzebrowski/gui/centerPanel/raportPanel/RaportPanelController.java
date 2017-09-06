package mzebrowski.gui.centerPanel.raportPanel;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextPane;

import mzebrowski.controller.ControllerElement;
import mzebrowski.database.domain.E_ExpenseType;
import mzebrowski.database.domain.wrappers.UserSumExpensesWrapper;
import mzebrowski.database.services.ServiceManager;

public class RaportPanelController implements ControllerElement {

	RaportPanel raportPanel;
	ServiceManager serviceManager;
	JTextPane groupMonthRaport;
	JTextPane groupAllTimeRaport;
	JTextPane toAvarageRaport;
	JLabel connectionStatus;

	public RaportPanelController(ServiceManager serviceManager, RaportPanel raportPanel) {
		this.serviceManager = serviceManager;
		this.raportPanel = raportPanel;
		this.groupMonthRaport = raportPanel.getGroupMonthRaport();
		this.groupAllTimeRaport = raportPanel.getGroupAllTimeRaport();
		this.toAvarageRaport = raportPanel.getToAvarageRaport();
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
