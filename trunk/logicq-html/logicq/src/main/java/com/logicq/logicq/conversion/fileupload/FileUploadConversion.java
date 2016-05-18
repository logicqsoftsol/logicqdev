package com.logicq.logicq.conversion.fileupload;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.model.upload.UploadFile;
import com.logicq.logicq.ui.fileupload.vo.FileUploadVO;

public class FileUploadConversion {

	private static FileUploadConversion instance;

	public static FileUploadConversion getInstance() {

		if (null == instance) {
			instance = new FileUploadConversion();
		}
		return instance;
	}

	public UploadFile conversionFromVOtoEntity(FileUploadVO fileUploadVO, UploadFile uploadFile) {

		uploadFile.setFileName(fileUploadVO.getUserid() +fileUploadVO.getFileType());
		uploadFile.setFileSize(fileUploadVO.getFileSize());
		uploadFile.setFileType(fileUploadVO.getFileType());
		uploadFile.setUserId(fileUploadVO.getUserid());
		uploadFile.setFileUploadDate(fileUploadVO.getUploadDate());
		uploadFile.setFilequalifyfor(fileUploadVO.getFilequalifyfor());
		return uploadFile;
	}

	public FileUploadVO conversionFromEntitytoVO(UploadFile uploadFile, FileUploadVO fileUploadVO) {

		fileUploadVO.setFileName(uploadFile.getFileName());
		fileUploadVO.setFileSize(uploadFile.getFileSize());
		fileUploadVO.setFileType(uploadFile.getFileType());
		fileUploadVO.setUserid(uploadFile.getUserId());
		fileUploadVO.setUploadDate(uploadFile.getFileUploadDate());
		fileUploadVO.setFilequalifyfor(uploadFile.getFilequalifyfor());
		return fileUploadVO;
	}

	public UploadFile handleConversionVOtoEntityWithContext(FileUploadVO fileUploadVO) {

		UploadFile uploadFile = null;
		if (null != LogicqContextProvider.getApplicationContext()) {
			uploadFile = LogicqContextProvider.getApplicationContext().getBean(UploadFile.class);
		}
		if (null == uploadFile) {
			uploadFile = new UploadFile();
		}
		return conversionFromVOtoEntity(fileUploadVO, uploadFile);
	}
}
