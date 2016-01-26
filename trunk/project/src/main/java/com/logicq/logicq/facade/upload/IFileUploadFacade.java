package com.logicq.logicq.facade.upload;

import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;

public interface IFileUploadFacade {
	
	void save(FileUploadRequest uploadFileRequest,FileUploadResponse uploadFileResponse );
	
	void delete(FileUploadRequest uploadFileRequest,FileUploadResponse uploadFileResponse);
}
