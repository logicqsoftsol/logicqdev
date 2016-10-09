package com.logicq.commonproject.service;

import com.logicq.commonproject.model.ContentDetails;
import com.logicq.commonproject.model.HomeContent;

public interface IContentModificationService {
	
	void saveorUpdateWebContent(ContentDetails contentdetails);

	void saveorUpdateHomeWebContent(HomeContent homecontent);

}
