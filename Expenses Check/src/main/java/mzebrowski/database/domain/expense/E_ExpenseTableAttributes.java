package mzebrowski.database.domain.expense;

import mzebrowski.database.domain.E_TableAttributes;

public enum E_ExpenseTableAttributes implements E_TableAttributes {
	ID("idExpenses"), NAME("name"), PURCHASE_TYPE("purchaseType"), AMOUNT("amount"), DATE("date"), USER_ID("userID");
	
	String name;
	E_ExpenseTableAttributes(String string)
	{
		name = string;
	}

	public String getAttributeName() {
		return this.toString();
	}
	
}
