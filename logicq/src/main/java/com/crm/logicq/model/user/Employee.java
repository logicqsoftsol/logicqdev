package com.crm.logicq.model.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.crm.logicq.model.common.BaseEntity;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6233410119222622143L;

	@Id
	@Column(name = "EMP_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IDENTIFICATION_ID", nullable = false)
	private String idetificationid;
	
	@Column(name = "USER_ID", nullable = false)
	private String userid;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BasicDetails basicdetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ContactDetails contactdetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdetificationid() {
		return idetificationid;
	}

	public void setIdetificationid(String idetificationid) {
		this.idetificationid = idetificationid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public BasicDetails getBasicdetails() {
		return basicdetails;
	}

	public void setBasicdetails(BasicDetails basicdetails) {
		this.basicdetails = basicdetails;
	}

	public ContactDetails getContactdetails() {
		return contactdetails;
	}

	public void setContactdetails(ContactDetails contactdetails) {
		this.contactdetails = contactdetails;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", idetificationid=" + idetificationid + ", userid=" + userid + ", basicdetails="
				+ basicdetails + ", contactdetails=" + contactdetails + "]";
	}
	
	
	
}
