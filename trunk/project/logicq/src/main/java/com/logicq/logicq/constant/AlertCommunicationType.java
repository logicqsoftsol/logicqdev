package com.logicq.logicq.constant;

public enum AlertCommunicationType {
	ADHOC("adhoc"), BATCH("batch");

	AlertCommunicationType(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {

		return value;
	}

	public void setValue(String value) {

		this.value = value;
	}
}
