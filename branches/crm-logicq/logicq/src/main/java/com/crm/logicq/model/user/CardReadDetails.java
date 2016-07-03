package com.crm.logicq.model.user;

import java.util.Date;

public class CardReadDetails {

	private int cardid;
	private int intime;
	private int outtime;

	public int getCardid() {

		return cardid;
	}

	public void setCardid(int cardid) {

		this.cardid = cardid;
	}

	public int getIntime() {

		return intime;
	}

	public void setIntime(int intime) {

		this.intime = intime;
	}

	public int getOuttime() {

		return outtime;
	}

	public void setOuttime(int outtime) {

		this.outtime = outtime;
	}

	public Date getCardswappdate() {

		return cardswappdate;
	}

	public void setCardswappdate(Date cardswappdate) {

		this.cardswappdate = cardswappdate;
	}

	private Date cardswappdate;
}
