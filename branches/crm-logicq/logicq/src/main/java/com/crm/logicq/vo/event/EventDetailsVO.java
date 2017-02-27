package com.crm.logicq.vo.event;

import com.crm.logicq.constant.EntityType;

/**
 * NIHAR 24-Jul-2016 2:27:50 pm
 */
public class EventDetailsVO {

	private long eventID;
	private String eventName;
	private String templatetext;
	private String eventtype;
	private String applicablefor;

	public long getEventID() {

		return eventID;
	}

	public void setEventID(long eventID) {

		this.eventID = eventID;
	}

	public String getTemplatetext() {

		return templatetext;
	}

	public void setTemplatetext(String templatetext) {

		this.templatetext = templatetext;
	}

	public String getEventtype() {

		return eventtype;
	}

	public void setEventtype(String eventtype) {

		this.eventtype = eventtype;
	}

	
    public String getEventName() {
    
    	return eventName;
    }

	
    public void setEventName(String eventName) {
    
    	this.eventName = eventName;
    }

	public String getApplicablefor() {
		return applicablefor;
	}

	public void setApplicablefor(String applicablefor) {
		this.applicablefor = applicablefor;
	}

	
   
	
}