package com.logicq.logicq.ui.user.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.ui.address.bean.AddressBean;

@ManagedBean(name = "entityAvalAtLocationBean")
@ViewScoped
public class EntityAvalAtLocationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2330030085899370312L;

	public Map<String, Boolean> getAllTimeSlot() {
		return allTimeSlot;
	}

	public void setAllTimeSlot(Map<String, Boolean> allTimeSlot) {
		this.allTimeSlot = allTimeSlot;
	}

	private String locationid;
	
	
	private String addresdetails;
	
	private Map< String,Boolean>  allTimeSlot;

	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

	public String getAddresdetails() {
		return addresdetails;
	}

	public void setAddresdetails(String addresdetails) {
		this.addresdetails = addresdetails;
	}


	
}
