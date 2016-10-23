package com.logicq.commonproject.service;

import java.util.List;

import com.logicq.commonproject.model.ContentDetails;
import com.logicq.commonproject.model.EventDetails;
import com.logicq.commonproject.model.HomeContent;

public interface IContentModificationService {
	
	void saveorUpdateWebContent(ContentDetails contentdetails);
	List<ContentDetails> getContentDetails();
	void saveorUpdateHomeWebContent(HomeContent homecontent);
	List<HomeContent> getHomeContent();
	public List<HomeContent> getHomeContent(String imageType);
	
    List<EventDetails> getEventDetails();
	
	void saveEvent(EventDetails eventdetails);
	void updateEvent(EventDetails eventdetails);
	void deleteEvent(EventDetails eventdetails);

}
