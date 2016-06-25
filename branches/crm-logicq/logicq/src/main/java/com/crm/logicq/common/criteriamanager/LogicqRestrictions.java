package com.crm.logicq.common.criteriamanager;

public enum LogicqRestrictions {

	
	LIKE  ("like"),  
	EQUALS  ("eq"),  
    BETWEEN("between");
  

    private final String restrictiontype;

    private LogicqRestrictions(String p_restrictiontype) {
        this.restrictiontype = p_restrictiontype;
    }
}


/**
NIHAR
01-Jan-2016
10:06:36 pm
*/