package com.crm.logicq.dao.calendar.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.calendar.ICalendarDAO;
import com.crm.logicq.model.calnder.CalendarDetails;

@Repository
public class CalendarDAO extends AbstractDAO<CalendarDetails> implements ICalendarDAO  {

	@Override
	public List<CalendarDetails> getAllEventCalendarDetails() throws Exception {
		return (List<CalendarDetails>) loadClass(CalendarDetails.class);
	}

	@Override
	public void saveEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception {
		saveOrUpdate(eventcalendardetail);
	}

	@Override
	public void deleteEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception {
	  delete(eventcalendardetail);	
	}

}
