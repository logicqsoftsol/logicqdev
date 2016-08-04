package com.crm.logicq.vo.event;

import java.util.Date;

public class CalendarDashBoardVO {
	private String eventname;
	private Long eventid;
	private Date eventdate;
	
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public Long getEventid() {
		return eventid;
	}
	public void setEventid(Long eventid) {
		this.eventid = eventid;
	}
	public Date getEventdate() {
		return eventdate;
	}
	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}
	

}
