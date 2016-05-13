package com.logicq.logicq.ui.fileupload.vo;

import java.io.Serializable;

public class FileUploadResponse   implements Serializable {
	private FileUploadVO fileupload;

	
	public FileUploadVO getFileupload() {
	
		return fileupload;
	}

	
	public void setFileupload(FileUploadVO fileupload) {
	
		this.fileupload = fileupload;
	}
}
