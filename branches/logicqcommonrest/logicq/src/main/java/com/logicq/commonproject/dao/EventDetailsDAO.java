package com.logicq.commonproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.commonproject.model.EventDetails;

@Repository
public class EventDetailsDAO extends AbstractDAO<EventDetails> implements IEventDetailsDAO {
	{

	}

	@Override
	public List<EventDetails> getEventDetails() {
		StringBuilder selectquery = new StringBuilder(" from EventDetails evt  order by evt.id desc ");
		return (List<EventDetails>) execcuteQueryWithLimitRecord(selectquery.toString(), 5);
	}

	@Override
	public void saveEvent(EventDetails eventdetails) {
		saveOrUpdate(eventdetails);
	}

	@Override
	public void updateEvent(EventDetails eventdetails) {
		saveOrUpdate(eventdetails);
	}

	@Override
	public void deleteEvent(EventDetails eventdetails) {
		delete(eventdetails);
	}
}
