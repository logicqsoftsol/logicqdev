/**
 * 
 */
package com.logicq.logicq.communication.model;

/**
 * @author SudhanshuLenka
 *
 */
public enum TemplateType {
	
	
	E_MAIL("email"),
	SMS("sms");

	private String templateType;
	private TemplateType(String templateType){
		this.templateType=templateType;
	}

	  @Override
	    public String toString() {
	        return templateType;
	    }
};

