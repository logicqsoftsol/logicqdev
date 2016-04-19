package com.logicq.logicq.ui.fileupload.vo;

import java.io.Serializable;

import com.logicq.logicq.common.LogicqHttpServletRequest;

public class FileUploadRequest extends LogicqHttpServletRequest implements Serializable {

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
