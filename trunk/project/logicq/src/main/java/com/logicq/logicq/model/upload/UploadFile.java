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
@Table(name = "FILE_UPLOAD")
public class UploadFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8806356173783436068L;
	@Id
	@Column(name = "FILE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "FILE_NAME")
	private String fileName;
	@Column(name = "FILE_SIZE")
	private String fileSize;
	@Column(name = "FILE_TYPE")
	private String fileType;
	@Column(name = "FILE_UPLOAD_DATE")
	private Date fileUploadDate;
	@Column(name = "USER_ID")
	private Long userId;
	@Column(name = "QUALIFIED_PATH")
	private String qualifiedPath;

	public String getFileSize() {

		return fileSize;
	}

	public void setFileSize(String fileSize) {

		this.fileSize = fileSize;
	}

	public Date getFileUploadDate() {

		return fileUploadDate;
	}

	public void setFileUploadDate(Date fileUploadDate) {

		this.fileUploadDate = fileUploadDate;
	}

	public Long getUserId() {

		return userId;
	}

	public void setUserId(Long userId) {

		this.userId = userId;
	}

	public String getQualifiedPath() {

		return qualifiedPath;
	}

	public void setQualifiedPath(String qualifiedPath) {

		this.qualifiedPath = qualifiedPath;
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
}
