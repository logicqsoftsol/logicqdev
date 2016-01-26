package com.logicq.logicq.model.upload;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name = "FILES_UPLOAD")
public class UploadFile implements Serializable {
	@Id
	@Column(name = "FILE_ID", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "FILE_DATA")
	private byte[] data;
    
	@Column(name = "FILE_SIZE")
	private String filesize;
	
	@Column(name = "FILE_TYPE")
	private String fileType;
	
	@Column(name = "FILE_UPLOAD_DATE")
	private Date fileuploadDate;
	
	@Column(name = "USERID")
	private Integer userid;
	
	
	public Integer getUserid() {
	
		return userid;
	}
	
	public void setUserid(Integer userid) {
	
		this.userid = userid;
	}


	public Date getFileuploadDate() {
	
		return fileuploadDate;
	}

	
	public void setFileuploadDate(Date fileuploadDate) {
	
		this.fileuploadDate = fileuploadDate;
	}

	public String getFilesize() {
	
		return filesize;
	}
	
	public void setFilesize(String filesize) {
	
		this.filesize = filesize;
	}

	public String getFileType() {
	
		return fileType;
	}


	
	public void setFileType(String fileType) {
	
		this.fileType = fileType;
	}


	public long getId() {
	
		return id;
	}

	
	public void setId(long id) {
	
		this.id = id;
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
