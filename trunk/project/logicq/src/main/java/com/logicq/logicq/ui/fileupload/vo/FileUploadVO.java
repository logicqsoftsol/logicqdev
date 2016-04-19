package com.logicq.logicq.ui.fileupload.vo;

import java.io.InputStream;
import java.util.Date;

public class FileUploadVO {

	private String fileName;
	private byte[] data;
	private String fileSize;
	private String fileType;
	private Date uploadDate;
	private Long userid;
	private InputStream inputStream;
	private String destinationPath;

	public String getDestinationPath() {

		return destinationPath;
	}

	public void setDestinationPath(String destinationPath) {

		this.destinationPath = destinationPath;
	}

	public InputStream getInputStream() {

		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {

		this.inputStream = inputStream;
	}

	public Long getUserid() {

		return userid;
	}

	public void setUserid(Long userid) {

		this.userid = userid;
	}

	public Date getUploadDate() {

		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {

		this.uploadDate = uploadDate;
	}

	public String getFileSize() {

		return fileSize;
	}

	public void setFileSize(String fileSize) {

		this.fileSize = fileSize;
	}

	public String getFileType() {

		return fileType;
	}

	public void setFileType(String fileType) {

		this.fileType = fileType;
	}

	public String getFileName() {

		return fileName;
	}

	public void setFileName(String fileName) {

		this.fileName = fileName;
	}

	public byte[] getData() {

		return data;
	}

	public void setData(byte[] data) {

		this.data = data;
	}
}
