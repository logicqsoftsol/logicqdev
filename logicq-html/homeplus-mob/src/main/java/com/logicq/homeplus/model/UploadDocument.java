package com.logicq.homeplus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DOCUMENT_UPLOAD_DETAILS")
public class UploadDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1213761286914479932L;
	
	@Id
	@Column(name = "DOCUEMNT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentID;
	
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name = "PATH")
	private String documentPath;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "UPLOAD_DATE", nullable = true)
	private Date uploadDate;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "UPLOAD_FOR")
	private String uploadFor;
	
	
	@Column(name = "SERVICE_TYPE")
	private String serviceType;

	public Long getDocumentID() {
		return documentID;
	}

	public void setDocumentID(Long documentID) {
		this.documentID = documentID;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUploadFor() {
		return uploadFor;
	}

	public void setUploadFor(String uploadFor) {
		this.uploadFor = uploadFor;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		return "UploadDocument [documentID=" + documentID + ", mobileNumber=" + mobileNumber + ", documentPath="
				+ documentPath + ", uploadDate=" + uploadDate + ", name=" + name + ", uploadFor=" + uploadFor
				+ ", serviceType=" + serviceType + "]";
	}

	
	
}
