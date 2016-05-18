package com.logicq.logicq.ui.fileupload.vo;

import java.util.Date;

import javax.servlet.http.Part;

import com.logicq.logicq.common.ConvertClass;

@ConvertClass(enable=true)
public class FileUploadVO {

	private String fileName;
	private String fileSize;
	private String fileType;
	private Date uploadDate;
	private Long userid;
	private String destinationPath;
	private String filequalifyfor;

	

	public String getFilequalifyfor() {
		return filequalifyfor;
	}

	public void setFilequalifyfor(String filequalifyfor) {
		this.filequalifyfor = filequalifyfor;
	}
	private Part file;

	public Part getFile() {

		return file;
	}

	public void setFile(Part file) {

		this.file = file;
	}

	public String getDestinationPath() {

		return destinationPath;
	}

	public void setDestinationPath(String destinationPath) {

		this.destinationPath = destinationPath;
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

	
}
