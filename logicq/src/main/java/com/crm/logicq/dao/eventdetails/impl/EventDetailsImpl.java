package com.crm.logicq.dao.eventdetails.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.eventdetails.IEventDetails;
import com.crm.logicq.model.event.EventDetails;
import com.crm.logicq.model.user.Student;

@Repository
public class EventDetailsImpl extends AbstractDAO<EventDetails> implements IEventDetails{

	@Override
	public List<EventDetails> getAllEventDetails() throws Exception {
		return (List<EventDetails>) loadClass(EventDetails.class);
	}

	
	@Override
	public EventDetails getEventDetails(Long eventid) throws Exception  {
		String query = " from EventDetails event where event.eventid="+eventid;
		return (EventDetails) execcuteQuery(query).get(0);
	}

	

	@Override
	public void deleteEventDetails(EventDetails eventdetails) throws Exception {
		EventDetails event = getEventDetails(eventdetails.getEventid());
		delete(event);
	}



	@Override
	public void saveEventDetails(EventDetails eventdetails) throws Exception {
		saveOrUpdate(eventdetails);
	}

}
