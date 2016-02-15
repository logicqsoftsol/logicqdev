package com.logicq.logicq.model.location;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;

@Entity
@Table(name = "LOCATION")
public class Location extends BaseEntity implements Serializable {

	/**
	 * NIHAR 26-Jan-2016 5:29:55 pm
	 */
	@Id
	@Column(name = "LOCATIONID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;
	@Column(name = "LOCATIONNAME", nullable = false)
	private String locationName;
	
	//@Column(name = "LOCALITY")
	private String locality;
	
	//@Column(name = "PINCODE", unique = true)
	private Long pincode;
	
	@Column(name = "LATITUDE", unique = true)
	private double latitude;
	
	@Column(name = "LONGITUDE", unique = true)
	private double longitude;
	
	

	
    public double getLatitude() {
    
    	return latitude;
    }

	
    public void setLatitude(double latitude) {
    
    	this.latitude = latitude;
    }

	
    public double getLongitude() {
    
    	return longitude;
    }

	
    public void setLongitude(double longitude) {
    
    	this.longitude = longitude;
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
