package com.logicq.logicq.ui.user.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.logicq.logicq.ui.location.bean.LocationBean;

@ManagedBean(name = "scheduleMB")
@ViewScoped
public class ScheduleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6109054539557839817L;

	private List<LocationBean> locationdetails;
	private List<AvailabilityBean> availabilityBeans;
	private Date scheduledate;

	public List<LocationBean> getLocationdetails() {
		return locationdetails;
	}

	public void setLocationdetails(List<LocationBean> locationdetails) {
		this.locationdetails = locationdetails;
	}

	public List<AvailabilityBean> getAvailabilityBeans() {
		return availabilityBeans;
	}

	public void setAvailabilityBeans(List<AvailabilityBean> availabilityBeans) {
		this.availabilityBeans = availabilityBeans;
	}

	public Date getScheduledate() {
		return scheduledate;
	}

	public void setScheduledate(Date scheduledate) {
		this.scheduledate = scheduledate;
	}

}
