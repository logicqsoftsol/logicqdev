package com.crm.logicq.constant;

public enum ContactType {
	 WORK("work"), HOME("home"),EMERGENCY("emergency");

	private String contactType;

	ContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactType() {

		return contactType;
	}
}
