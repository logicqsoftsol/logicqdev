package com.logicq.logicq.dao.upload.impl;

import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.upload.IFileUploadDAO;
import com.logicq.logicq.model.upload.UploadFile;

public class FileUploadDAO  extends AbstractDAO<UploadFile> implements IFileUploadDAO{


	public void save(UploadFile uploadFile) {
		save(uploadFile,null);
	}

	
	public void delete(UploadFile uploadFile) {
		delete(uploadFile,null);
	}
}
