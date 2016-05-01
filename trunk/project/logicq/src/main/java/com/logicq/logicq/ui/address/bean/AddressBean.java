package com.logicq.logicq.ui.address.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.address.helper.AddressHelper;
import com.logicq.logicq.ui.address.vo.AddressVO;


@ManagedBean(name = "addressMB")
@ViewScoped
public class AddressBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3985758943975376624L;
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
	private String latitude;
	private String longitude;
	List<String> addresslist;
	List<String> entitylist;
	List<String> latlonglist;
	private String addressImagePath; 
	
	
	  public AddressBean(){
			addresslist = getLocation();
			entitylist = getEntity();
			latlonglist = getLatLong();
		}
		
	
    public String getAddressImagePath() {
		return addressImagePath;
	}

	public void setAddressImagePath(String addressImagePath) {
		this.addressImagePath = addressImagePath;
	}

	public String getLatitude() {
    
    	return latitude;
    }
	
    public void setLatitude(String latitude) {
    
    	this.latitude = latitude;
    }
	
    public String getLongitude() {
    
    	return longitude;
    }
	
    public void setLongitude(String longitude) {
    
    	this.longitude = longitude;
    }
	
    public List<String> getLatlonglist() {
    
    	return latlonglist;
    }
	
    public void setLatlonglist(List<String> latlonglist) {
    
    	this.latlonglist = latlonglist;
    }

	
	
    public List<String> getAddresslist() {
    
    	return addresslist;
    }
	
    public void setAddresslist(List<String> addresslist) {
    
    	this.addresslist = addresslist;
    }
	
    public List<String> getEntitylist() {
    
    	return entitylist;
    }
	
    public void setEntitylist(List<String> entitylist) {
    
    	this.entitylist = entitylist;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getLocation() {

		AddressManagedBean addressManagedBean = LogicqContextProvider.getApplicationContext().getBean(AddressManagedBean.class);
		return addressManagedBean.getAddress();
	}

	public List<String> getEntity() {

		AddressManagedBean addressManagedBean = LogicqContextProvider.getApplicationContext().getBean(AddressManagedBean.class);
		return addressManagedBean.getEntity();
	}
	 	public List<String> getLatLong() {

	 		AddressManagedBean addressManagedBean = LogicqContextProvider.getApplicationContext().getBean(AddressManagedBean.class);
			 return addressManagedBean. getAllLocation();
			 
		} 

}
