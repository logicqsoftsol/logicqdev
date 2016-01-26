
package com.logicq.logicq.service.upload.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.conversion.fileupload.FileUploadConversion;
import com.logicq.logicq.dao.upload.IFileUploadDAO;
import com.logicq.logicq.service.upload.IFileUploadService;
import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;

public class FileUploadService implements IFileUploadService {

	FileUploadConversion fileuploadConversion = FileUploadConversion.getInstance();
	@Autowired
	private IFileUploadDAO fileUploadDAO;

	public IFileUploadDAO getFileUploadDAO() {

		return fileUploadDAO;
	}

	public void setFileUploadDAO(IFileUploadDAO fileUploadDAO) {

		this.fileUploadDAO = fileUploadDAO;
	}

	public void save(FileUploadRequest uploadFileRequest, FileUploadResponse uploadFileResponse) {

		fileUploadDAO.save(fileuploadConversion.handleConversionVOtoEntityWithContext(uploadFileRequest.getFileupload()));
	}

	public void delete(FileUploadRequest uploadFileRequest, FileUploadResponse uploadFileResponse) {

		fileUploadDAO.delete(fileuploadConversion.handleConversionVOtoEntityWithContext(uploadFileRequest.getFileupload()));
	}
}
