package com.logicq.logicq.constant;

public enum AvilableEnum {

	AVILABLE("avilable"), BOOKED("booked"), NOTAVILABLE("notavilable"),NOTAPPLICABLE("notaplicable");

	private String  timeSlot;

	AvilableEnum(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getTimeSlot() {
		return timeSlot;
	}
}
