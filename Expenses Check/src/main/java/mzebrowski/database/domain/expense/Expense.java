package mzebrowski.database.domain.expense;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.user.User;

@Entity
@Table(name = "Expenses")
public class Expense {

	@Id
	@GeneratedValue
	private int idExpenses;

	@Column(name = "name", length = 20)
	private String name;

	@Column
	@Enumerated(EnumType.ORDINAL)
    private E_PurchaseType purchaseType;
	
	@Column(name = "amount", nullable = false, precision = 4, scale = 2)
	private double amount;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private java.util.Date date;

	@ManyToOne
	@JoinColumn(name = "userID")
	private User userID;

	public int getIdExpenses() {
		return idExpenses;
	}

	public void setIdExpenses(int idExpenses) {
		this.idExpenses = idExpenses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public E_PurchaseType getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(E_PurchaseType purchaseType) {
		this.purchaseType = purchaseType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

}
