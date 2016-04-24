package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.logicq.logicq.constant.EntityType;

public class AvilablityVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9213137611418009221L;
	
	private Date avilabledate;

	private String profileid;

	private String entityid;
	
	private EntityType entityType;

    private String locationid;
	
	private String addresdetails;
	
	public Date getAvilabledate() {
		return avilabledate;
	}

	public void setAvilabledate(Date avilabledate) {
		this.avilabledate = avilabledate;
	}

	public String getProfileid() {
		return profileid;
	}

	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}

	public String getEntityid() {
		return entityid;
	}

	public void setEntityid(String entityid) {
		this.entityid = entityid;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

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

	public Map<String, Boolean> getAvilablTimeSlot() {
		return avilablTimeSlot;
	}

	public void setAvilablTimeSlot(Map<String, Boolean> avilablTimeSlot) {
		this.avilablTimeSlot = avilablTimeSlot;
	}

	private Map< String,Boolean>  avilablTimeSlot;

}
