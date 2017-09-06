package mzebrowski.gui.centerPanel;

public enum E_Incomes {
	INCOME("Incomes"), EXPENSE("Expenses");

	private final String name;

	private E_Incomes(String s) {
		name = s;
	}

	public String toString() {
		return this.name;
	}

	public boolean equalsName(String otherName) {
		return name.equals(otherName);
	}
}
