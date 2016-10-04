package com.logicq.commonproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.commonproject.dao.IFIleUploadDAO;
import com.logicq.commonproject.model.FileUpload;

@Service
@Transactional
public class FileUploadService implements IFileUploadService{

	@Autowired
	IFIleUploadDAO fileuploaddao;
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void uploadFile(FileUpload fileupload) {
		fileuploaddao.saveUploadFile(fileupload);
	}

}
