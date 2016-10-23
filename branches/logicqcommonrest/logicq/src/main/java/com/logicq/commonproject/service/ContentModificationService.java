package com.logicq.commonproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.commonproject.dao.IContentModificationDAO;
import com.logicq.commonproject.dao.IEventDetailsDAO;
import com.logicq.commonproject.dao.IHomeContentModificationDAO;
import com.logicq.commonproject.model.ContentDetails;
import com.logicq.commonproject.model.EventDetails;
import com.logicq.commonproject.model.HomeContent;

@Service
@Transactional
public class ContentModificationService implements IContentModificationService {

	@Autowired
	IContentModificationDAO contentmodification;
	
	@Autowired
	IHomeContentModificationDAO homecontentmodification;
	
	@Autowired
	IEventDetailsDAO eventdao;
	
	
	@Override
	public void saveorUpdateWebContent(ContentDetails contentdetails) {
		contentmodification.saveWebContent(contentdetails);	
	}


	@Override
	public void saveorUpdateHomeWebContent(HomeContent homecontent) {
		homecontentmodification.saveorUpdateHomeWebContent(homecontent);
	}


	@Override
	public List<ContentDetails> getContentDetails() {
		// TODO Auto-generated method stub
		return contentmodification.getWebContent();
	}


	@Override
	public List<HomeContent> getHomeContent() {
		return homecontentmodification.getHomeWebContent();
	}
	@Override
	public List<HomeContent> getHomeContent(String imageType) {
		return homecontentmodification.getHomeWebContent(imageType);
	}


	@Override
	public List<EventDetails> getEventDetails() {
		return eventdao.getEventDetails();
	}


	@Override
	public void saveEvent(EventDetails eventdetails) {
		eventdao.saveEvent(eventdetails);
	}


	@Override
	public void updateEvent(EventDetails eventdetails) {
		eventdao.saveEvent(eventdetails);
	}


	@Override
	public void deleteEvent(EventDetails eventdetails) {
		eventdao.deleteEvent(eventdetails);
	}

}
