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

import mzebrowski.database.domain.enums.E_ExpenseType;
import mzebrowski.database.domain.enums.E_PurchaseType;
import mzebrowski.database.domain.user.User;

@Entity
@Table(name = "Expenses")
public class Expense {

	@Id
	@GeneratedValue
	private int idExpenses;

	@Column(name = "discription", length = 20)
	private String discription;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
    private E_PurchaseType purchaseType;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
    private E_ExpenseType expenseType;
	
	@Column(name = "amount", nullable = false, precision = 4, scale = 2)
	private double amount;

	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date date;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	public int getIdExpenses() {
		return idExpenses;
	}

	public void setIdExpenses(int idExpenses) {
		this.idExpenses = idExpenses;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public E_ExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(E_ExpenseType expenseType) {
		this.expenseType = expenseType;
	}

	@Override
	public String toString()
	{
		return "" + getAmount() + ", " + getDate() + ", " + getDiscription() + ", " + getPurchaseType() + ", " + getUser().toString();  
	}
}
