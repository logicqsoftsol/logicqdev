package com.logicq.homeplus.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ServiceList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2591455166486039155L;
	private Date fromdate;
	private Date todate;
	private String dayInterval;
	private int serviceCount;
	private List<ServiceDetailVO> serviceList;

	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public int getServiceCount() {
		return serviceCount;
	}
	public void setServiceCount(int serviceCount) {
		this.serviceCount = serviceCount;
	}
	public List<ServiceDetailVO> getServiceList() {
		return serviceList;
	}
	public void setServiceList(List<ServiceDetailVO> serviceList) {
		this.serviceList = serviceList;
	}
	public String getDayInterval() {
		return dayInterval;
	}
	public void setDayInterval(String dayInterval) {
		this.dayInterval = dayInterval;
	}
	@Override
	public String toString() {
		return "ServiceList [fromdate=" + fromdate + ", todate=" + todate + ", dayInterval=" + dayInterval
				+ ", serviceCount=" + serviceCount + ", serviceList=" + serviceList + "]";
	}

}
