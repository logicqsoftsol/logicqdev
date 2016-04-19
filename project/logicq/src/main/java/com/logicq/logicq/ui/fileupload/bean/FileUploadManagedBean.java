package com.logicq.logicq.ui.fileupload.bean;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.fileupload.helper.FileUploadHelper;
import com.logicq.logicq.ui.fileupload.properties.FileUploadImageProperties;
import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;
import com.logicq.logicq.ui.fileupload.vo.FileUploadVO;

public class FileUploadManagedBean {

	public void upload(FileUploadBean fileUploadBean) {

		FileUploadVO fileUpload = LogicqContextProvider.getApplicationContext().getBean(FileUploadVO.class);
		FileUploadRequest fileuploadrequest = LogicqContextProvider.getApplicationContext().getBean(FileUploadRequest.class);
		FileUploadResponse fileuploadresponse = LogicqContextProvider.getApplicationContext().getBean(FileUploadResponse.class);
		FileUploadImageProperties fileUploadImageProperties = LogicqContextProvider.getApplicationContext().getBean(FileUploadImageProperties.class);
		FileUploadHelper helper = LogicqContextProvider.getApplicationContext().getBean(FileUploadHelper.class);
		FileUploadHelper.conversionUItoVO(fileUploadBean, fileUpload);
		fileUpload.setDestinationPath(fileUploadImageProperties.getDestinationPath());
		fileuploadrequest.setFileupload(fileUpload);
		helper.uploadDocument(fileuploadrequest, fileuploadresponse);
	}
}
