 
package com.logicq.logicq.ui.location.vo;

import javax.persistence.Column;


public class LocationVO {
	private Long locationId;
	private String locationName;
	private String locality;
	private Long pincode;
	
    public Long getLocationId() {
    
    	return locationId;
    }
	
    public void setLocationId(Long locationId) {
    
    	this.locationId = locationId;
    }
	
    public String getLocationName() {
    
    	return locationName;
    }
	
    public void setLocationName(String locationName) {
    
    	this.locationName = locationName;
    }
	
    public String getLocality() {
    
    	return locality;
    }
	
    public void setLocality(String locality) {
    
    	this.locality = locality;
    }
	
    public Long getPincode() {
    
    	return pincode;
    }
	
    public void setPincode(Long pincode) {
    
    	this.pincode = pincode;
    }
}


/**
NIHAR
31-Jan-2016
1:22:44 am
*/