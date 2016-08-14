package com.issuetraker.constant;

public enum EventType {

	 EXAM("exam"), DURGA_PUJA("holiday"),SUMMER_VACCATION("emergency");

	private String eventtype;

	EventType(String eventtype) {
		this.eventtype = eventtype;
	}

	public String getEventType() {

		return eventtype;
	}

}
