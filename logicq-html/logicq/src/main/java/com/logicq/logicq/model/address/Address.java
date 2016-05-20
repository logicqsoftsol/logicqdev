package com.logicq.logicq.model.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.logicq.logicq.common.ConvertClass;
import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.constant.ComunicationAddress;
import com.logicq.logicq.constant.ContactType;
import com.logicq.logicq.model.user.User;

@ConvertClass
@Entity
@Table(name = "USER_ADDRESS")
public class Address extends BaseEntity implements AddressConstant, Serializable {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 172703959951786066L;
	@Id
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	@Column(name = "HOUSE_NUMBER", nullable = true)
	private String housenumber;
	@Column(name = "FLOOR_NUMBER", nullable = true)
	private String floornumber;
	@Column(name = "STREET_NAME", nullable = true)
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
	@Column(name = "COMMUNICATION_ADDRESS_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private ComunicationAddress communicationaddress;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = true)
	private User user;
	
	@Column(name = "DEFAULT_ADDRESS_FLAG", nullable = false)
	private Boolean defaultAddressFlag;
	@Column(name = "CONTACT_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	@Column(name = "CONTACT_NUMBER", nullable = false)
	private String contactNumber;
	@Column(name = "latitude", nullable = true)
	private String latitude;
	@Column(name = "longitude", nullable = true)
	private String longitude;

	
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

	public ContactType getContactType() {

		return contactType;
	}

	public void setContactType(ContactType contactType) {

		this.contactType = contactType;
	}

	public String getContactNumber() {

		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {

		this.contactNumber = contactNumber;
	}

	public Long getAddressId() {

		return addressId;
	}

	public void setAddressId(Long addressId) {

		this.addressId = addressId;
	}

	public Boolean getDefaultAddressFlag() {

		return defaultAddressFlag;
	}

	public void setDefaultAddressFlag(Boolean defaultAddressFlag) {

		this.defaultAddressFlag = defaultAddressFlag;
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

		return "Address [addressId="
		       + addressId
		       + ", housenumber="
		       + housenumber
		       + ", floornumber="
		       + floornumber
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
		       + ", defaultAddressFlag="
		       + defaultAddressFlag
		       + "]";
	}
}
