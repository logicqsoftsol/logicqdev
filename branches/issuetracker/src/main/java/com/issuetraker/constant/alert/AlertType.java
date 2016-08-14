package com.issuetraker.constant.alert;

public enum AlertType {

	SMS("sms"), EMAIL("email"), TWITTER("twitter");

	AlertType(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {

		return value;
	}
}
