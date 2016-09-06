package com.logicq.common.criteriamanager;

public enum OperationType {

		INSERT  ("INSERT"),  
	  	DELETE  ("DELETE"), 
	  	SELECT  ("SELECT"), 
	    UPDATE("UPDATE");
	  

	    private final String operationType;

	    private OperationType(String operationType) {
	        this.operationType = operationType;
	    }
}


