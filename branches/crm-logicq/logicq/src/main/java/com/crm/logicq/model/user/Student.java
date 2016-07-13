package com.crm.logicq.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.crm.logicq.model.common.BaseEntity;

@Entity
@Table(name = "STUDENT")
public class Student extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 814670978583852457L;

	@Id
	@Column(name = "STUDENT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IDENTIFICATION_ID", nullable = false)
	private String idetificationid;
	
	@Column(name = "USER_ID", nullable = false)
	private String userid;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "REG_DATE", nullable = false)
	private Date regdate;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private BasicDetails basicdetails;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ContactDetails contactdetails;

	
	
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

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
		return "Student [id=" + id + ", idetificationid=" + idetificationid + ", userid=" + userid + ", regdate="
				+ regdate + ", basicdetails=" + basicdetails + ", contactdetails=" + contactdetails + "]";
	}



}
