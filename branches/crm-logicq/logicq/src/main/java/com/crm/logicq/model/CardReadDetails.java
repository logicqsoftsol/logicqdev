package com.crm.logicq.model;

import java.util.Date;

public class CardReadDetails {
	
	private String cardid;
	private String  intime;
	private String  outtime;
	private Date cardswappdate;
	
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
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
	public Date getCardswappdate() {
		return cardswappdate;
	}
	public void setCardswappdate(Date cardswappdate) {
		this.cardswappdate = cardswappdate;
	}

}
