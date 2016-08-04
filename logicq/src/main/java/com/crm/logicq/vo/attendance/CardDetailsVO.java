package com.crm.logicq.vo.attendance;

import java.util.Date;

public class CardDetailsVO {
	
	private String cardid;
	private String intime;
	private String outtime;
	private Date cardswapdate;
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
	public Date getCardswapdate() {
		return cardswapdate;
	}
	public void setCardswapdate(Date cardswapdate) {
		this.cardswapdate = cardswapdate;
	}
	

}
