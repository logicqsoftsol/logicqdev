package com.crm.logicq.model.user;

import java.util.Date;

public class CardReadDetails {

	private Integer cardid;
	private Integer intime;
	private Integer outtime;

	public Integer getCardid() {

		return cardid;
	}

	public void setCardid(Integer cardid) {

		this.cardid = cardid;
	}

	public Integer getIntime() {

		return intime;
	}

	public void setIntime(Integer intime) {

		this.intime = intime;
	}

	public int getOuttime() {

		return outtime;
	}

	public void setOuttime(Integer outtime) {

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
