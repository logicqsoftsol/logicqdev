package com.logicq.logicq.service.upload;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;

public interface IFileUploadService {
	@ExceptionHandler(Exception.class)
	void save(FileUploadRequest uploadFileRequest,FileUploadResponse uploadFileResponse );
	
	@ExceptionHandler(Exception.class)
	void delete(FileUploadRequest uploadFileRequest,FileUploadResponse uploadFileResponse);
}
