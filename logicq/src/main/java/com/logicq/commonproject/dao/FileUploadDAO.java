package com.logicq.commonproject.dao;

import org.springframework.stereotype.Repository;

import com.logicq.commonproject.model.FileUpload;

@Repository
public class FileUploadDAO extends AbstractDAO<FileUpload> implements IFIleUploadDAO{

	@Override
	public void saveUploadFile(FileUpload fileupload) {
		saveOrUpdate(fileupload);
	}

}
