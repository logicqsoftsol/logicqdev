package com.logicq.commonproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.commonproject.dao.IContentModificationDAO;
import com.logicq.commonproject.model.ContentDetails;

@Service
@Transactional
public class ContentModificationService implements IContentModificationService {

	@Autowired
	IContentModificationDAO contentmodification;
	
	
	@Override
	public void saveorUpdateWebContent(ContentDetails contentdetails) {
		contentmodification.saveWebContent(contentdetails);	
	}

}
