package com.crm.logicq.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMMUNICATION_DETAILS")
public class CommunicationDetails {
	
	@Id
	@Column(name = "COMMUNICATION_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "MOBILE_NUMBER", nullable = true)
	private String mobilenumber;
	
	@Column(name = "EMAIL", nullable = true)
	private String emailid;
	
	@Column(name = "EMERGENCY_CONTACT_NO", nullable = true)
	private String emergencycontactnumber;
	
	@Column(name = "TYPE", nullable = true)
	private String communicationtype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getEmergencycontactnumber() {
		return emergencycontactnumber;
	}

	public void setEmergencycontactnumber(String emergencycontactnumber) {
		this.emergencycontactnumber = emergencycontactnumber;
	}

	public String getCommunicationtype() {
		return communicationtype;
	}

	public void setCommunicationtype(String communicationtype) {
		this.communicationtype = communicationtype;
	}

	@Override
	public String toString() {
		return "CommunicationDetails [id=" + id + ", mobilenumber=" + mobilenumber + ", emailid=" + emailid
				+ ", emergencycontactnumber=" + emergencycontactnumber + ", communicationtype=" + communicationtype
				+ "]";
	}
	
	
	

}
