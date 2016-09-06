package com.logicq.electionmgm.constant;

public enum ContactType {
	 WORK("work"), HOME("home"),EMERGENCY("emergency"),DALIY_ATTENDANCE("attendance");

	private String contactType;

	ContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactType() {

		return contactType;
	}
}
