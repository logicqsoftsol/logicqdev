package com.logicq.logicq.communication.model;

public enum SendingType {
	ONLINE("online"),
	BATCH("batch"),
	NIGHT_TIME("nighttime"),
	DEFAULT("default");
	
	private String sendingtype;
	private SendingType(String sendingtype){
		this.sendingtype=sendingtype;
	}
	 @Override
	    public String toString() {
	        return sendingtype;
	    }
};
