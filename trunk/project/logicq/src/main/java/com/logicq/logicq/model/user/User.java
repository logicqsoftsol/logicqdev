package com.logicq.logicq.model.user;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import com.logicq.logicq.common.criteriamanager.LogicqAbstractDataObject;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.login.Role;

/**
 * @author Rocky
 */
@Entity
@Table(name = "USER")
@NamedQueries({ @NamedQuery(name = User.GET_USER, query = User.GET_USER_QUERY),
                @NamedQuery(name = User.GET_MOBILE_NO, query = User.GET_MOBILE_NO_QRY),
                @NamedQuery(name = User.GET_EMAIL_ID, query = User.GET_EMAIL_ID_QRY) })
public class User extends LogicqAbstractDataObject implements UserConstant, Serializable {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 6692634947354854155L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FIRST_NAME", unique = true, nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", unique = true, nullable = false)
	private String lastName;
	@Column(name = "GENDER", unique = true, nullable = false)
	private String gender;
	@Column(name = "MOBILE_NUMBER", unique = true, nullable = false)
	private String mobileNo;
	@Column(name = "EMAIL_ID", unique = true, nullable = false)
	private String emailId;
	@Column(name = "DOB", unique = true, nullable = false)
	private String dateOfBirth;
	@Column(name = "USER_PASSWORD", unique = true, nullable = false)
	private String password;
	@Column(name = "MOB_VERIFICATION_FLAG", unique = true, nullable = false)
	private Boolean isMobileVerified;
	@Column(name = "EMAIL_VERIFICATION_FLAG", unique = true, nullable = false)
	private Boolean isEmailVerified;
	@Column(name = "USER_VERIFICATION_FLAG", unique = true, nullable = false)
	private Boolean isUserVerified;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Address> addresses;

	public Set<Address> getAddresses() {

		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {

		this.addresses = addresses;
	}

	public Boolean getIsUserVerified() {

		return isUserVerified;
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

	public String getMobileNo() {

		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {

		this.mobileNo = mobileNo;
	}

	public String getEmailId() {

		return emailId;
	}

	public void setEmailId(String emailId) {

		this.emailId = emailId;
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

	public Boolean getIsMobileVerified() {

		return isMobileVerified;
	}

	public void setIsMobileVerified(Boolean isMobileVerified) {

		this.isMobileVerified = isMobileVerified;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles_map", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "role_id") })
	private Set<Role> role;

	public Set<Role> getRole() {

		return role;
	}

	public void setRole(Set<Role> role) {

		this.role = role;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_facilities_map", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "facility_id", referencedColumnName = "facility_id") })
	private Set<Facility> facilities;

	public Set<Facility> getFacilities() {

		return facilities;
	}

	public void setFacilities(Set<Facility> facilities) {

		this.facilities = facilities;
	}
}
