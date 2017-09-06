package mzebrowski.database.domain.wrappers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import mzebrowski.database.domain.user.User;

public class UserSumExpensesWrapper {

	User user;
	double sumedExpenses;

	public UserSumExpensesWrapper(User user, double sumedExpenses) {
		this.user = user;
		this.sumedExpenses = sumedExpenses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getSumedExpenses() {
		return sumedExpenses;
	}

	public void setSumedExpenses(Double sumedExpenses) {
		this.sumedExpenses = sumedExpenses;
	}

}
