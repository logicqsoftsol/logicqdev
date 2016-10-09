package com.logicq.commonproject.dao;

import java.util.List;

import com.logicq.commonproject.model.ContentDetails;

public interface IContentModificationDAO {
	
	void saveWebContent(ContentDetails contentdetails);
	List<ContentDetails> getWebContent();

}
