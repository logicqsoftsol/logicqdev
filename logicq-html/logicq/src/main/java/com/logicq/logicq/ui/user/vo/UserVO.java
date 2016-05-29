package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.logicq.logicq.common.ConvertClass;
import com.logicq.logicq.constant.EntityType;
import com.logicq.logicq.ui.address.vo.AddressVO;

@ConvertClass(enable=true)
public class UserVO extends BasicUserVO implements Serializable {

	private static final long serialVersionUID = 6692634947354854155L;
	
	private Long id;
	
	private String firstName;
	private String lastName;
	private String gender;
	
	private Date dateOfBirth;
	
	private String token;
	
	private Boolean isMobileVerified=false;
	
	private Boolean isEmailVerified=false;
	
	private Boolean isUserVerified=false;
	
	private List<AddressVO> addresses;
	
	private EntityType entityType;
	
	
	private List<RoleVO> role;

	
	private List<FacilityVO> facilities;
	
	
	private ProfileVO profile;
	

	private List<ServiceReportVO> serviceReport;

	
	

	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Long getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getGender() {
		return gender;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}




	public Boolean getIsMobileVerified() {
		return isMobileVerified;
	}


	public Boolean getIsEmailVerified() {
		return isEmailVerified;
	}


	public Boolean getIsUserVerified() {
		return isUserVerified;
	}


	public List<AddressVO> getAddresses() {
		return addresses;
	}


	public EntityType getEntityType() {
		return entityType;
	}


	public List<RoleVO> getRole() {
		return role;
	}


	public List<FacilityVO> getFacilities() {
		return facilities;
	}


	public ProfileVO getProfile() {
		return profile;
	}


	public List<ServiceReportVO> getServiceReport() {
		return serviceReport;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	

	public void setIsMobileVerified(Boolean isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}


	public void setIsEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}


	public void setIsUserVerified(Boolean isUserVerified) {
		this.isUserVerified = isUserVerified;
	}


	public void setAddresses(List<AddressVO> addresses) {
		this.addresses = addresses;
	}


	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}


	public void setRole(List<RoleVO> role) {
		this.role = role;
	}


	public void setFacilities(List<FacilityVO> facilities) {
		this.facilities = facilities;
	}


	public void setProfile(ProfileVO profile) {
		this.profile = profile;
	}


	public void setServiceReport(List<ServiceReportVO> serviceReport) {
		this.serviceReport = serviceReport;
	}


	@Override
	public String toString() {
		return "UserVO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", token=" + token + ", isMobileVerified=" + isMobileVerified
				+ ", isEmailVerified=" + isEmailVerified + ", isUserVerified=" + isUserVerified + ", addresses="
				+ addresses + ", entityType=" + entityType + ", role=" + role + ", facilities=" + facilities
				+ ", profile=" + profile + ", serviceReport=" + serviceReport + "]";
	}


}
