package com.logicq.logicq.service.upload;

import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;

public interface IFileUploadService {
	void save(FileUploadRequest uploadFileRequest,FileUploadResponse uploadFileResponse );
	
	void delete(FileUploadRequest uploadFileRequest,FileUploadResponse uploadFileResponse);
}
