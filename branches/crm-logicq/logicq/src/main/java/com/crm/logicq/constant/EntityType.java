package com.crm.logicq.constant;

public enum EntityType {
	EMPLOYEE("employee"), STUDENT("student");

	private String type;

	EntityType(String type) {
		this.type = type;
	}

	String getValue() {

		return type;
	}
}
