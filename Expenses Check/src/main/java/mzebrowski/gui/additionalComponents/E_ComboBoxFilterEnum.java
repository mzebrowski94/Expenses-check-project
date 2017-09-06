package mzebrowski.gui.additionalComponents;

public enum E_ComboBoxFilterEnum {
	ALL("All");
	
	private final String name;

	private E_ComboBoxFilterEnum(String s) {
		name = s;
	}

	public String toString() {
		return this.name;
	}
}
