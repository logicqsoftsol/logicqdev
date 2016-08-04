package com.crm.logicq.model.user;

import java.util.Date;

import com.crm.logicq.common.MSColumn;
import com.crm.logicq.common.MSTable;

@MSTable(name="Tran_DeviceAttRec")
public class CardReadDetails {

	@MSColumn(name="Card_Number")
	private String cardid;
	
	@MSColumn(name="Att_PunchRecDate")
	private Date punchdate;
	
	@MSColumn(name="Punch_month")
	private Date  punchmonth;

	
	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public Date getPunchdate() {
		return punchdate;
	}

	public void setPunchdate(Date punchdate) {
		this.punchdate = punchdate;
	}

	public Date getPunchmonth() {
		return punchmonth;
	}

	public void setPunchmonth(Date punchmonth) {
		this.punchmonth = punchmonth;
	}
	

}
