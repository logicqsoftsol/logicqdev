package com.logicq.homeplus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_DETAIL")
public class ServiceDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8460558880785591129L;

	@Id
	@Column(name = "SERVICE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "SERVICE_NAME", nullable = false)
	private String servicename;
	
	@Column(name = "SERVICE_REQUEST_DATE", nullable = false)
	private Date serviceRequestDate;
	
	
	@Column(name = "SERVICE_DATE", nullable = false)
	private Date servicedate;
	
	@Column(name = "SERVICE_TIME", nullable = false)
	private String servicetime;
	
	@Column(name = "CUSTOMER_NAME", nullable = false)
	private String customername;
	
	
	@Column(name = "CUSTMOER_MOB", nullable = false)
	private String customermob;
	
	
	@Column(name = "CUSTOMER_ADDRESS", nullable = true)
	private String customeraddress;
	
	@Column(name = "REFRENCE_NUMBER", nullable = true)
	private String refrenceNumber;
	
	
	@Column(name = "SERVICE_STATUS", nullable = true)
	private String serviceStatus;
	
	@Column(name = "DOCUMENT_ID", nullable = true)
	private long documentId;
	
	@Column(name = "REQUEST_DETAILS", nullable = true)
    private String requestDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public Date getServiceRequestDate() {
		return serviceRequestDate;
	}

	public void setServiceRequestDate(Date serviceRequestDate) {
		this.serviceRequestDate = serviceRequestDate;
	}

	public Date getServicedate() {
		return servicedate;
	}

	public void setServicedate(Date servicedate) {
		this.servicedate = servicedate;
	}

	public String getServicetime() {
		return servicetime;
	}

	public void setServicetime(String servicetime) {
		this.servicetime = servicetime;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomermob() {
		return customermob;
	}

	public void setCustomermob(String customermob) {
		this.customermob = customermob;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getRefrenceNumber() {
		return refrenceNumber;
	}

	public void setRefrenceNumber(String refrenceNumber) {
		this.refrenceNumber = refrenceNumber;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	public String getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}

	@Override
	public String toString() {
		return "ServiceDetails [id=" + id + ", servicename=" + servicename + ", serviceRequestDate="
				+ serviceRequestDate + ", servicedate=" + servicedate + ", servicetime=" + servicetime
				+ ", customername=" + customername + ", customermob=" + customermob + ", customeraddress="
				+ customeraddress + ", refrenceNumber=" + refrenceNumber + ", serviceStatus=" + serviceStatus
				+ ", documentId=" + documentId + ", requestDetails=" + requestDetails + "]";
	}

	

}
