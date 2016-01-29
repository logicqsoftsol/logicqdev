package com.logicq.logicq.model.location;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.LogicqAbstractDataObject;

@Entity
@Table(name = "LOCATION")
public class Location extends LogicqAbstractDataObject implements Serializable {
	/**
	 * NIHAR 26-Jan-2016 5:29:55 pm
	 */
	@Id
	@Column(name = "LOCATIONID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;
	@Column(name = "LOCATIONNAME", unique = true, nullable = false)
	private String locationName;
	
	
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
	 
}
