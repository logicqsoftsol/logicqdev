package com.logicq.commonproject.dao;

import org.springframework.stereotype.Repository;

import com.logicq.commonproject.model.ContentDetails;
import com.logicq.commonproject.model.HomeContent;

@Repository
public class ContentModificationDAO extends AbstractDAO<ContentDetails> implements IContentModificationDAO{

	@Override
	public void saveWebContent(ContentDetails contentdetails) {
	  saveOrUpdate(contentdetails);
	}

	@Override
	public void saveorUpdateHomeWebContent(HomeContent homecontent) {
		// TODO Auto-generated method stub
		
	}

}
