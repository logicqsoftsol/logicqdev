package com.crm.logicq.vo.event;

import java.io.Serializable;
import java.util.Date;

import com.crm.logicq.model.common.CommonProperty;

public class CalendarCriteria extends CommonProperty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3894422262825388122L;
	
	private Date todate;
	private Date fromdate;
	private int limitValue;
	
	
	
	public int getLimitValue() {
		return limitValue;
	}
	public void setLimitValue(int limitValue) {
		this.limitValue = limitValue;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	

}
