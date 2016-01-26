package com.logicq.logicq.facade.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.service.upload.IFileUploadService;
import com.logicq.logicq.service.upload.impl.FileUploadService;
import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;

public class FileUploadFacade implements IFileUploadFacade{

	@Autowired
	private IFileUploadService fileUploadService;

	
	public IFileUploadService getFileUploadService() {
	
		return fileUploadService;
	}

	
	public void setFileUploadService(IFileUploadService fileUploadService) {
	
		this.fileUploadService = fileUploadService;
	}

	@Transactional(readOnly = false)
	public void save(FileUploadRequest uploadFileRequest, FileUploadResponse uploadFileResponse) {
		fileUploadService.save(uploadFileRequest, uploadFileResponse);
	}

	@Transactional(readOnly = false)
	public void delete(FileUploadRequest uploadFileRequest, FileUploadResponse uploadFileResponse) {
		fileUploadService.delete(uploadFileRequest, uploadFileResponse);
		
	}
}
