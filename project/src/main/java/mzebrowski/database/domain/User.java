package mzebrowski.database.domain;

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

	@Column(table = "last_purchase", name = "Last_purchase_type")
	private PurchaseType lastPusrchaseType;

	@Column(table = "last_purchase", name = "last_purchase_description", length = 20)
	private String lastPurchaseDescription;
	
	@OneToMany(mappedBy = "userId")
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

	public PurchaseType getLastPusrchaseType() {
		return lastPusrchaseType;
	}

	public void setLastPusrchaseType(PurchaseType lastPusrchaseType) {
		this.lastPusrchaseType = lastPusrchaseType;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public String getLastPurchaseDescription() {
		return lastPurchaseDescription;
	}
 
	public void setLastPurchaseDescription(String lastPurchaseDescription) {
		this.lastPurchaseDescription = lastPurchaseDescription;
	}

	public int getIdUser() {
		return idUser;
	}

	public PurchaseType getLastPurchaseType() {
		return lastPusrchaseType;
	}

	public void setLastPurchaseType(PurchaseType lastPurchaseType) {
		this.lastPusrchaseType = lastPurchaseType;
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

	public double getAccount_balance() {
		return accountBalance;
	}

	public void setAccount_balance(double account_balance) {
		this.accountBalance = account_balance;
	}

	public java.util.Date getData() {
		return lastUpdate;
	}

	public void setData(java.util.Date data) {
		this.lastUpdate = data;
	}

}
