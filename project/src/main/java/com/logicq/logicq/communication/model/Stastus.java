package com.logicq.logicq.communication.model;

public enum Stastus {
	
	SUCESS("sucess"),
	FAIL("fail"),
	WAITING("waiting");

	private String stastus;
	private Stastus(String stastus){
		this.stastus=stastus;
	}
	 @Override
	    public String toString() {
	        return stastus;
	    }
};
