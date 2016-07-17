package com.crm.logicq.dao.calendar;

import java.util.List;

import com.crm.logicq.model.calnder.CalendarDetails;

public interface ICalendarDAO {
	
	public List<CalendarDetails> getAllEventCalendarDetails() throws Exception;

	public void saveEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception;

	public void deleteEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception;

}
