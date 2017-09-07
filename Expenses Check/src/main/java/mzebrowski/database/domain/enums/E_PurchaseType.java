package mzebrowski.database.domain.enums;

public enum E_PurchaseType {
	SHOPPING("Shopping"), FOOD("Food"), BILLS("Bills"), TICKET("Ticket"), OTHER("Other");
	
	String name;
	
	E_PurchaseType(String name)
	{
		this.name=name;
	}
	
	@Override
	public String toString() {
		return name;	
	}

}
