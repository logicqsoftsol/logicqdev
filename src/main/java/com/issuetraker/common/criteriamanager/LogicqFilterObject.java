package com.issuetraker.common.criteriamanager;

public class LogicqFilterObject {

	
	private String fieldname;
	
	private Object fieldvalue;
	
	private LogicqRestrictions restricationtype;

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public Object getFieldvalue() {
		return fieldvalue;
	}

	public void setFieldvalue(Object fieldvalue) {
		this.fieldvalue = fieldvalue;
	}

	public LogicqRestrictions getRestricationtype() {
		return restricationtype;
	}

	public void setRestricationtype(LogicqRestrictions restricationtype) {
		this.restricationtype = restricationtype;
	}
}


/**
NIHAR
01-Jan-2016
8:46:03 pm
*/