package com.logicq.logicq.ui.fileupload.vo;

import java.io.Serializable;

public class FileUploadRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8899297946755907752L;
	private FileUploadVO fileupload;

	public FileUploadVO getFileupload() {

		return fileupload;
	}

	public void setFileupload(FileUploadVO fileupload) {

		this.fileupload = fileupload;
	}
}
