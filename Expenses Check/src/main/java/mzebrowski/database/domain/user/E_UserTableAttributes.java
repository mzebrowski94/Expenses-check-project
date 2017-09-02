package mzebrowski.database.domain.user;

import mzebrowski.database.domain.E_TableAttributes;

public enum E_UserTableAttributes implements E_TableAttributes {
	ID("idUser"), USER_NAME("userName"), PASSWORD("password"), ACCOUNT_BALANCE("account_balance"), LAST_UPDATE("last_update");
	
	String name;
	E_UserTableAttributes(String string)
	{
		name = string;
	}

	public String getAttributeName() {
		return this.toString();
	}
}
