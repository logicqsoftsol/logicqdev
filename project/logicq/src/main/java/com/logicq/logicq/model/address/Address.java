package com.logicq.logicq.model.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.logicq.logicq.common.criteriamanager.LogicqAbstractDataObject;
import com.logicq.logicq.constant.ComunicationAddress;
import com.logicq.logicq.model.user.User;


public class Address extends LogicqAbstractDataObject implements AddressConstant, Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "HOUSE_NUMBER", nullable = true)
	private String housenumber;
	
	@Column(name = "FLOOR_NUMBER", nullable = true)
	private String floornumber;
	
	@Column(name = "BULDING_NUMBER", nullable = true)
	private String buldingnumber;
	
	@Column(name = "STREET_NUMBER", nullable = true)
	private String streetname;
	
	@Column(name = "LOCALITY", nullable = true)
	private String localityname;
	
	@Column(name = "LANDMARK", nullable = false)
	private String landmarkname;
	
	@Column(name = "CITY", nullable = false)
	private String city;
	
	@Column(name = "STATE", nullable = false)
	private String state;
	
	
	@Column(name = "PINCODE", nullable = false)
	private String pincode;
	
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	
	@Enumerated(EnumType.STRING)
	private ComunicationAddress communicationaddress;
	
	@ManyToOne
	@JoinColumn(name = "ID" )
	private User user;
	
	public Long getId() {
	
		return id;
	}


	public void setId(Long id) {
	
		this.id = id;
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

	
	public ComunicationAddress getCommunicationaddress() {
	
		return communicationaddress;
	}

	
	public void setCommunicationaddress(ComunicationAddress communicationaddress) {
	
		this.communicationaddress = communicationaddress;
	}

	
	public User getUser() {
	
		return user;
	}

	
	public void setUser(User user) {
	
		this.user = user;
	}
	
	@Override
	public String toString() {

		return "Address [id="
		       + id
		       + ", housenumber="
		       + housenumber
		       + ", floornumber="
		       + floornumber
		       + ", buldingnumber="
		       + buldingnumber
		       + ", streetname="
		       + streetname
		       + ", localityname="
		       + localityname
		       + ", landmarkname="
		       + landmarkname
		       + ", city="
		       + city
		       + ", state="
		       + state
		       + ", pincode="
		       + pincode
		       + ", country="
		       + country
		       + ", communicationaddress="
		       + communicationaddress
		       + ", user="
		       + user
		       + "]";
	}
	

}
