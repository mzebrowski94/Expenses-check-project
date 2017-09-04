package mzebrowski.database.domain;

public enum E_ExpenseType {
	OWN("Own"), GROUP("Group");

	String name;

	E_ExpenseType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
