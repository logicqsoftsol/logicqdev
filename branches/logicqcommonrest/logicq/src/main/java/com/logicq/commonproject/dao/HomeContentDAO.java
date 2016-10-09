package com.logicq.commonproject.dao;

import org.springframework.stereotype.Repository;

import com.logicq.commonproject.model.ContentDetails;
import com.logicq.commonproject.model.HomeContent;

@Repository
public class HomeContentDAO extends AbstractDAO<HomeContent> implements IContentModificationDAO{

	@Override
	public void saveWebContent(ContentDetails contentdetails) {

	}

	@Override
	public void saveorUpdateHomeWebContent(HomeContent homecontent) {
		 saveOrUpdate(homecontent);
	}

}
