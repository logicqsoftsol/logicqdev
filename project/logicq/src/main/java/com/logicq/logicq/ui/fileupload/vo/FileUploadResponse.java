package com.logicq.logicq.ui.fileupload.vo;

import java.io.Serializable;

import com.logicq.logicq.common.LogicqHttpServletResponse;

public class FileUploadResponse  extends LogicqHttpServletResponse implements Serializable {
	private FileUploadVO fileupload;

	
	public FileUploadVO getFileupload() {
	
		return fileupload;
	}

	
	public void setFileupload(FileUploadVO fileupload) {
	
		this.fileupload = fileupload;
	}
}
