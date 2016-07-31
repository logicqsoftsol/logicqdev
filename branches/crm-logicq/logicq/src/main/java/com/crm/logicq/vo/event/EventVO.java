package com.crm.logicq.vo.event;

import java.io.Serializable;
import java.util.List;

import com.crm.logicq.model.event.EventDetails;

public class EventVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1754067236727904395L;
	
	private List<EventDetails> eventdetails;
	private EventCriteria eventcriteria;
	public List<EventDetails> getEventdetails() {
		return eventdetails;
	}
	public void setEventdetails(List<EventDetails> eventdetails) {
		this.eventdetails = eventdetails;
	}
	public EventCriteria getEventcriteria() {
		return eventcriteria;
	}
	public void setEventcriteria(EventCriteria eventcriteria) {
		this.eventcriteria = eventcriteria;
	}
	@Override
	public String toString() {
		return "EventVO [eventdetails=" + eventdetails + ", eventcriteria=" + eventcriteria + "]";
	}
	
	
	

}
