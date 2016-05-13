package com.logicq.logicq.ui.fileupload.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.service.upload.IFileUploadService;
import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;

public class FileUploadHelper {

	@Autowired
	IFileUploadService fileUploadFacade;



	public void uploadDocument(FileUploadRequest uploadFileRequest, FileUploadResponse uploadFileResponse) {

		fileUploadFacade.save(uploadFileRequest, uploadFileResponse);
	}

	
}
