package com.logicq.logicq.ui.user.vo;

import java.util.List;

import com.logicq.logicq.ui.address.vo.AddressVO;

public class UserVO {

	private int id;
	private String name;
	private String surname;
	private String ipaddress;
	private String emailId;
	private String mobileNo;
	private String dateOfBirth;
	private String password;
	private String gender;
	private List<FacilityVO> facilities;
	private RoleVO role;
	private ProfileVO profile;
	private ServiceReportVO serviceReport;
	private AddressVO address;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<FacilityVO> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<FacilityVO> facilities) {
		this.facilities = facilities;
	}

	public RoleVO getRole() {
		return role;
	}

	public void setRole(RoleVO role) {
		this.role = role;
	}

	public ProfileVO getProfile() {
		return profile;
	}

	public void setProfile(ProfileVO profile) {
		this.profile = profile;
	}

	public ServiceReportVO getServiceReport() {
		return serviceReport;
	}

	public void setServiceReport(ServiceReportVO serviceReport) {
		this.serviceReport = serviceReport;
	}

	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}

	


}
