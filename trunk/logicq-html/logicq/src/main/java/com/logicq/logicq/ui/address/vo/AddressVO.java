package com.logicq.logicq.ui.address.vo;

import com.logicq.logicq.common.ConvertClass;

@ConvertClass
public class AddressVO {
	
	private String housenumber;
	private String floornumber;
	private String buldingnumber;
	private String streetname;
	private String localityname;
	private String landmarkname;
	private String city;
	private String state;
	private String pincode;
	private String country;
	private String landphone;
	private String mobilenumber;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getFloornumber() {
		return floornumber;
	}
	public void setFloornumber(String floornumber) {
		this.floornumber = floornumber;
	}
	public String getBuldingnumber() {
		return buldingnumber;
	}
	public void setBuldingnumber(String buldingnumber) {
		this.buldingnumber = buldingnumber;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getLocalityname() {
		return localityname;
	}
	public void setLocalityname(String localityname) {
		this.localityname = localityname;
	}
	public String getLandmarkname() {
		return landmarkname;
	}
	public void setLandmarkname(String landmarkname) {
		this.landmarkname = landmarkname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLandphone() {
		return landphone;
	}
	public void setLandphone(String landphone) {
		this.landphone = landphone;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

}
