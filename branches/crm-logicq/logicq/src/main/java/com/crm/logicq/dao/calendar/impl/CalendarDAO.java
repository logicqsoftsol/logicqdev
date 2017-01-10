package com.crm.logicq.dao.calendar.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.calendar.ICalendarDAO;
import com.crm.logicq.model.calnder.CalendarDetails;
import com.crm.logicq.model.event.EventDetails;
import com.crm.logicq.vo.event.CalendarCriteria;

@Repository
public class CalendarDAO extends AbstractDAO<CalendarDetails> implements ICalendarDAO  {

	@Override
	public List<CalendarDetails> getAllEventCalendarDetails(CalendarCriteria calendarcriteria) throws Exception {
		StringBuilder  selectquery= new StringBuilder("from CalendarDetails cal ");
		if (1 == calendarcriteria.getPagenumber()) {
			Long recordcount=getRecordCount(CalendarDetails.class);
			calendarcriteria.setTotalrecordcount(recordcount.intValue());
		}
		if(null!=calendarcriteria.getFromdate() && null!=calendarcriteria.getTodate()){
			selectquery.append(" Where cal.eventstartdate >= '"+calendarcriteria.getFromdate()+"'" + " order by cal.eventstartdate asc");
		}
		return executeQueryWithPaginationAndLimitation(selectquery.toString(), calendarcriteria.getPagenumber(), calendarcriteria.getPagesize(), calendarcriteria.getLimitValue());
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