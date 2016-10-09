package com.logicq.commonproject.service;

import java.util.List;

import com.logicq.commonproject.model.ContentDetails;
import com.logicq.commonproject.model.HomeContent;

public interface IContentModificationService {
	
	void saveorUpdateWebContent(ContentDetails contentdetails);
	List<ContentDetails> getContentDetails();
	void saveorUpdateHomeWebContent(HomeContent homecontent);
	List<HomeContent> getHomeContent();

}
