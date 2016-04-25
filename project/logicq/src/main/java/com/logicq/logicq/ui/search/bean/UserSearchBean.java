package com.logicq.logicq.ui.search.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.user.bean.UserBean;

@ManagedBean(name = "userSearchMB")
@ViewScoped
public class UserSearchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5987953879794515014L;
	
	private String city;
	private String state;
	private String country;
	private String streetname;
	private String localityname;
	private String landmarkname;
	private String pincode;
	private String searchText;
	private String entity;
	private String searchlocation;

	@ManagedProperty(value = "#{userBean}")
    private UserBean userBean;  

	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	
	public String getSearchlocation() {
		return searchlocation;
	}

	public void setSearchlocation(String searchlocation) {
		this.searchlocation = searchlocation;
	}

	public String searchUsers() {
		UserSearchManagedBean userSearchManagedBean = LogicqContextProvider.getApplicationContext().getBean(UserSearchManagedBean.class);
		userSearchManagedBean.searchUsers(this);
		return "searchresult";
	}

	public String getEntity() {

		return entity;
	}

	public void setEntity(String entity) {

		this.entity = entity;
	}

	public String getSearchText() {

		return searchText;
	}

	public void setSearchText(String searchText) {

		this.searchText = searchText;
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

	public String getCountry() {

		return country;
	}

	public void setCountry(String country) {

		this.country = country;
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

	public String getPincode() {

		return pincode;
	}

	public void setPincode(String pincode) {

		this.pincode = pincode;
	}
}
