package com.logicq.logicq.ui.fileupload.bean;

import java.io.IOException;
import java.io.InputStream;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.fileupload.helper.FileUploadHelper;
import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;
import com.logicq.logicq.ui.fileupload.vo.FileUploadVO;

public class FileUploadManagedBean {
	
	public void upload(FileUploadBean fileUploadBean){
		FileUploadVO fileupload=LogicqContextProvider.getApplicationContext().getBean(FileUploadVO.class);
		FileUploadRequest fileuploadrequest=LogicqContextProvider.getApplicationContext().getBean(FileUploadRequest.class);
		FileUploadResponse fileuploadresponse=LogicqContextProvider.getApplicationContext().getBean(FileUploadResponse.class);
		FileUploadHelper helper=LogicqContextProvider.getApplicationContext().getBean(FileUploadHelper.class);
		FileUploadHelper.conversionUItoVO(fileUploadBean, fileupload);
		fileuploadrequest.setFileupload(fileupload);
		helper.uploadDocument(fileuploadrequest,fileuploadresponse);
	}
}
