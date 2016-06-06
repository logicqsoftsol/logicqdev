package com.logicq.logicq.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.logicq.logicq.common.ConvertClass;
import com.logicq.logicq.common.ConvertField;
import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.constant.EntityType;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.login.Role;
import com.logicq.logicq.model.user.facility.Facility;
import com.logicq.logicq.model.user.servicereport.ServiceReport;

/**
 * @author Rocky
 */
@ConvertClass(enable = true)
@Entity
@Table(name = "USER")
@NamedQueries({ @NamedQuery(name = User.GET_USER, query = User.GET_USER_QUERY),
		@NamedQuery(name = User.GET_MOBILE_NO, query = User.GET_MOBILE_NO_QRY),
		@NamedQuery(name = User.GET_EMAIL_ID, query = User.GET_EMAIL_ID_QRY),
		@NamedQuery(name = User.GET_USERS_NEAR_ADDRESS, query = User.GET_USERS_NEAR_ADDRESS_QRY),
		@NamedQuery(name = User.GET_PARTICULAR_USERS_NEAR_ADDRESS, query = User.GET_PARTICULAR_USERS_NEAR_ADDRESS_QRY) })
public class User extends BaseEntity implements UserConstant, Serializable {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 6692634947354854155L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FIRST_NAME", nullable = true)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = true)
	private String lastName;
	@Column(name = "GENDER", nullable = true)
	private String gender;
	@Column(name = "MOBILE_NUMBER", unique = true, nullable = false)
	private String phone;
	@Column(name = "EMAIL_ID", unique = true, nullable = false)
	private String email;
	@Column(name = "DOB", nullable = true)
	private Date dateOfBirth;
	@Column(name = "USER_PASSWORD", nullable = false)
	private String password;
	@Column(name = "MOB_VERIFICATION_FLAG", nullable = false)
	private Boolean isMobileVerified;
	@Column(name = "EMAIL_VERIFICATION_FLAG", nullable = false)
	private Boolean isEmailVerified;
	@Column(name = "USER_VERIFICATION_FLAG", nullable = false)
	private Boolean isUserVerified;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Address> addresses;
	@Column(name = "ENTITY_TYPE", nullable = true)
	@Enumerated(EnumType.STRING)
	private EntityType entityType;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles_map", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "role_id") })
	private Set<Role> role;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_facilities_map", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "facility_id", referencedColumnName = "facility_id") })
	private Set<Facility> facilities;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private Profile profile;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<ServiceReport> serviceReport;

	public Set<ServiceReport> getServiceReport() {
		return serviceReport;
	}

	public void setServiceReport(Set<ServiceReport> serviceReport) {
		this.serviceReport = serviceReport;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {

		this.addresses = addresses;
	}

	public Boolean getIsUserVerified() {

		return isUserVerified;
	}

	public EntityType getEntityType() {

		return entityType;
	}

	public void setEntityType(EntityType entityType) {

		this.entityType = entityType;
	}

	public void setIsUserVerified(Boolean isUserVerified) {

		this.isUserVerified = isUserVerified;
	}

	public void setIsEmailVerified(Boolean isEmailVerified) {

		this.isEmailVerified = isEmailVerified;
	}

	/**
	 * Get User Id
	 * 
	 * @return int - User Id
	 */
	public Long getId() {

		return id;
	}

	/**
	 * Set User Id
	 * 
	 * @param int
	 *            - User Id
	 */
	public void setId(Long id) {

		this.id = id;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public Boolean getIsEmailVerified() {

		return isEmailVerified;
	}

	public String getGender() {

		return gender;
	}

	public void setGender(String gender) {

		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public Boolean getIsMobileVerified() {

		return isMobileVerified;
	}

	public void setIsMobileVerified(Boolean isMobileVerified) {

		this.isMobileVerified = isMobileVerified;
	}

	public Set<Role> getRole() {

		return role;
	}

	public void setRole(Set<Role> role) {

		this.role = role;
	}

	public Set<Facility> getFacilities() {

		return facilities;
	}

	public void setFacilities(Set<Facility> facilities) {

		this.facilities = facilities;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", password=" + password
				+ ", isMobileVerified=" + isMobileVerified + ", isEmailVerified=" + isEmailVerified
				+ ", isUserVerified=" + isUserVerified + ", addresses=" + addresses + ", entityType=" + entityType
				+ ", role=" + role + ", facilities=" + facilities + ", profile=" + profile + ", serviceReport="
				+ serviceReport + "]";
	}

}
