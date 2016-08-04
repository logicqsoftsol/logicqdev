package com.crm.logicq.ui.alert;

import java.util.Date;

public class NotificationParamVO {

	private String name;

	private String intime;
	private String outtime;
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "NotificationParamVO [name=" + name + ", intime=" + intime + ", outtime=" + outtime + ", date=" + date
				+ "]";
	}

	
}
