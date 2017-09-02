package mzebrowski.database.domain.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mzebrowski.database.domain.expense.Expense;

@Entity
@Table(name = "Users")
@SecondaryTable(name = "Last_Purchase", pkJoinColumns = @PrimaryKeyJoinColumn(name = "UserId")) // additional table for
																								// lastPurchaseType,
																								// lastPurchaseDescription
public class User {

	@Id
	@GeneratedValue
	private int idUser;

	@Column(name = "user_name", nullable = false, length = 20, unique = true)
	private String userName;

	@Column(name = "password", nullable = false, length = 20)
	private String password;

	@Column(name = "account_balance", precision = 5, scale = 2)
	private double accountBalance;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_update")
	private java.util.Date lastUpdate;
	
	@OneToMany(mappedBy = "userID")
	private List<Expense> expenses;	
	
	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public java.util.Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(java.util.Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public java.util.Date getData() {
		return lastUpdate;
	}

	public void setData(java.util.Date data) {
		this.lastUpdate = data;
	}

	@Override
	public String toString()
	{
		return userName;
	}
}
