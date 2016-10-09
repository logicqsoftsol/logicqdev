package com.logicq.commonproject.dao;

import java.util.List;

import com.logicq.commonproject.model.HomeContent;

public interface IHomeContentModificationDAO {
	
	void saveorUpdateHomeWebContent(HomeContent homecontent);
	List<HomeContent> getHomeWebContent();

}
