package com.logicq.logicq.ui.search.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.logicq.logicq.common.ConvertClass;
import com.logicq.logicq.ui.user.vo.UserVO;

@ConvertClass(enable=true)
public class UserSearchVO {

	private String city;
	private String state;
	private String country;
	private String streetname;
	private String localityname;
	private String landmarkname;
	private String pincode;
	@NotNull
	private String searchText;
	private String entity;
	@NotNull
	private String searchlocation;
	private List<UserVO> uservo;

	public List<UserVO> getUservo() {
		return uservo;
	}

	public void setUservo(List<UserVO> uservo) {
		this.uservo = uservo;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getSearchlocation() {
		return searchlocation;
	}

	public void setSearchlocation(String searchlocation) {
		this.searchlocation = searchlocation;
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
