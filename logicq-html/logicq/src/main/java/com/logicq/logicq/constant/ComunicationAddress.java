package com.logicq.logicq.constant;

public enum ComunicationAddress {
	HOME("home"), OFFICE("office"), DEFAULT("default");

	String addressType;

	ComunicationAddress(String address) {
		addressType = address;
	}

	String getValue() {

		return addressType;
	}
}
