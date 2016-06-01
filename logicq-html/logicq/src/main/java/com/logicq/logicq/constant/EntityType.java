package com.logicq.logicq.constant;

public enum EntityType {
	DOCTOR("doctor"), PLUMBER("plumber"), ELECTRICIAN("electrician"),
	PATHALOGY("Pathalogy"),PHARMACY("Pharmacy"),BEAUTY("Beauty"),YOGA("Yoga"),HOSPITAL("Hospital");

	private String type;

	EntityType(String type) {
		this.type = type;
	}

	String getValue() {

		return type;
	}
}
