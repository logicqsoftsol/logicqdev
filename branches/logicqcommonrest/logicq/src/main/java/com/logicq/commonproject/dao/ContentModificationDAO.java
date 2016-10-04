package com.logicq.commonproject.dao;

import org.springframework.stereotype.Repository;

import com.logicq.commonproject.model.ContentDetails;

@Repository
public class ContentModificationDAO extends AbstractDAO<ContentDetails> implements IContentModificationDAO{

	@Override
	public void saveWebContent(ContentDetails contentdetails) {
	  saveOrUpdate(contentdetails);
	}

}
