package com.crm.logicq.model.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ADDRESS_DETAILS")
public class AddressDetails {

	@Id
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "ADDRESS_TEXT", nullable = true)
	private String addresstext;
	
	@Column(name = "LANDMARK", nullable = true)
	private String landmark;
	
	@Column(name = "CITY", nullable = true)
	private String city;
	
	@Column(name = "PINCODE", nullable = true)
	private String pincode;
	
	
	@Column(name = "STATE", nullable = true)
	private String state;
	
	@Column(name = "COUNTRY", nullable = true)
	private String country;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="CONTACT_ID")
	private ContactDetails contactdetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddresstext() {
		return addresstext;
	}

	public void setAddresstext(String addresstext) {
		this.addresstext = addresstext;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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

	public ContactDetails getContactdetails() {
		return contactdetails;
	}

	public void setContactdetails(ContactDetails contactdetails) {
		this.contactdetails = contactdetails;
	}

	
	@Override
	public String toString() {
		return "AddressDetails [id=" + id + ", addresstext=" + addresstext + ", landmark=" + landmark + ", city=" + city
				+ ", pincode=" + pincode + ", state=" + state + ", country=" + country + "]";
	}

	
	
}
