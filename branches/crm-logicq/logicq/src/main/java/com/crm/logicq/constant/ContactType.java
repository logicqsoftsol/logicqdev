package com.crm.logicq.constant;

public enum ContactType {
	MOBILE("mobile"), WORK("work"), HOME("home");

	private String contactType;

	ContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactType() {

		return contactType;
	}
}
