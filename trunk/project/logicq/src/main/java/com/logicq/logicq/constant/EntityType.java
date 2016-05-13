package com.logicq.logicq.constant;

public enum EntityType {
	DOCTOR("doctor"), PLUMBER("plumber"), ELECTRICIAN("electrician"), SERVICE_CONSUMER("serviceconsumer");

	private String type;

	EntityType(String type) {
		this.type = type;
	}

	String getValue() {

		return type;
	}
}
