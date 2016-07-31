package com.crm.logicq.dao.calendar;

import java.util.List;

import com.crm.logicq.model.calnder.CalendarDetails;
import com.crm.logicq.vo.event.CalendarCriteria;

public interface ICalendarDAO {
	
	public List<CalendarDetails> getAllEventCalendarDetails(CalendarCriteria calendarcriteria) throws Exception;

	public void saveEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception;

	public void deleteEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception;

}
