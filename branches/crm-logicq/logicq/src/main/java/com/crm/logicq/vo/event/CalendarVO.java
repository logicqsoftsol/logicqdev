package com.crm.logicq.vo.event;

import java.io.Serializable;
import java.util.List;

import com.crm.logicq.model.calnder.CalendarDetails;

public class CalendarVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3079507485431765400L;
	
	private List<CalendarDetails> calendardetailslist;
	private CalendarCriteria calendarcriteria;
	
	public List<CalendarDetails> getCalendardetailslist() {
		return calendardetailslist;
	}
	public void setCalendardetailslist(List<CalendarDetails> calendardetailslist) {
		this.calendardetailslist = calendardetailslist;
	}
	public CalendarCriteria getCalendarcriteria() {
		return calendarcriteria;
	}
	public void setCalendarcriteria(CalendarCriteria calendarcriteria) {
		this.calendarcriteria = calendarcriteria;
	}

}
