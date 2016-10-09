package com.logicq.commonproject.dao;

import com.logicq.commonproject.model.ContentDetails;
import com.logicq.commonproject.model.HomeContent;

public interface IContentModificationDAO {
	
	void saveWebContent(ContentDetails contentdetails);
	void saveorUpdateHomeWebContent(HomeContent homecontent);

}
