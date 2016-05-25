package com.logicq.logicq.ui.search.vo;

import com.logicq.logicq.common.ConvertClass;
import com.logicq.logicq.constant.EntityType;

@ConvertClass(enable=true)
public class BaseSearchVO {
	
	private String city;
	private String state;
	private String country;
	private String localityname;
	private String pincode;
	private String firstname;
	private String lastname;
	private String searchlocation;
	private Long addressid;
	private Long userid;
	private EntityType entityType;
	private String latitude;
	private String longitude;
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getLocalityname() {
		return localityname;
	}
	public String getPincode() {
		return pincode;
	}
	
	public String getSearchlocation() {
		return searchlocation;
	}
	public Long getAddressid() {
		return addressid;
	}
	public Long getUserid() {
		return userid;
	}
	public EntityType getEntityType() {
		return entityType;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setLocalityname(String localityname) {
		this.localityname = localityname;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setSearchlocation(String searchlocation) {
		this.searchlocation = searchlocation;
	}
	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "BaseSearchVO [city=" + city + ", state=" + state + ", country=" + country + ", localityname="
				+ localityname + ", pincode=" + pincode + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", searchlocation=" + searchlocation + ", addressid=" + addressid + ", userid=" + userid
				+ ", entityType=" + entityType + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}


}
