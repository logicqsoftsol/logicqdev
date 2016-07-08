package com.crm.logicq.model.attendance;

import java.util.Date;

public class AttendanceCriteria {
	private String userid;
	private String mobileno;
	private String cardno;
	private Date fromdate;
	private Date todate;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	
	@Override
	public String toString() {
		return "AttendanceCriteria [userid=" + userid + ", mobileno=" + mobileno + ", cardno=" + cardno + ", fromdate="
				+ fromdate + ", todate=" + todate + "]";
	}

}
