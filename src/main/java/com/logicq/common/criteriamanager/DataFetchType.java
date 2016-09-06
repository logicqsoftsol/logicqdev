package com.logicq.common.criteriamanager;

public enum DataFetchType {

	  SINGLE_RECORD  ("Single"),  
	    LIST_RECORD("List");
	  

	    private final String levelCode;

	    private DataFetchType(String levelCode) {
	        this.levelCode = levelCode;
	    }
}


