package com.logicq.homeplus.model;

import java.io.Serializable;
import java.util.Date;

public class ServiceDetailVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7005686846232012951L;
	
	private String customername;
	private String status;
	private Date requestDate;
	private Date serviceDate;
	private String location;
	private String customermob;
	private String imageURL;
	private String serviceDetails;
	private String refrenceNumber;
	private String servicetime;
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCustomermob() {
		return customermob;
	}
	public void setCustomermob(String customermob) {
		this.customermob = customermob;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getServiceDetails() {
		return serviceDetails;
	}
	public void setServiceDetails(String serviceDetails) {
		this.serviceDetails = serviceDetails;
	}
	public String getRefrenceNumber() {
		return refrenceNumber;
	}
	public void setRefrenceNumber(String refrenceNumber) {
		this.refrenceNumber = refrenceNumber;
	}
	public String getServicetime() {
		return servicetime;
	}
	public void setServicetime(String servicetime) {
		this.servicetime = servicetime;
	}
	@Override
	public String toString() {
		return "ServiceDetailVO [customername=" + customername + ", status=" + status + ", requestDate=" + requestDate
				+ ", serviceDate=" + serviceDate + ", location=" + location + ", customermob=" + customermob
				+ ", imageURL=" + imageURL + ", serviceDetails=" + serviceDetails + ", refrenceNumber=" + refrenceNumber
				+ ", servicetime=" + servicetime + "]";
	}
	
}
