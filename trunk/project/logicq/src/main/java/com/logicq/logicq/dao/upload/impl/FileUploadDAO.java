package com.logicq.logicq.dao.upload.impl;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.upload.IFileUploadDAO;
import com.logicq.logicq.model.upload.UploadFile;

@Repository
public class FileUploadDAO  extends AbstractDAO<UploadFile> implements IFileUploadDAO{


	public void save(UploadFile uploadFile) {
		save(uploadFile);
	}

	
	public void delete(UploadFile uploadFile) {
		delete(uploadFile);
	}
}
