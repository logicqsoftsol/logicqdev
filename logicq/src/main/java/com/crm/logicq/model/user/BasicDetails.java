package com.crm.logicq.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.crm.logicq.model.common.BaseEntity;

@Entity
@Table(name = "BASIC_DETAILS")
public class BasicDetails extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1224269473343036124L;

	@Id
	@Column(name = "BASIC_PROF_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TITLE", nullable = true)
	private String title;
	
	@Column(name = "FIRST_NAME", nullable = true)
	private String firstname;
	
	@Column(name = "MIDDLE_NAME", nullable = true)
	private String middlename;
	
	@Column(name = "LAST_NAME", nullable = true)
	private String lastname;
	
	
	@Column(name = "GENDER", nullable = true)
	private String gender;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE", nullable = true)
	private Date dateofbirth;
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return "BasicDetails [id=" + id + ", title=" + title + ", firstname=" + firstname + ", middlename=" + middlename
				+ ", lastname=" + lastname + ", gender=" + gender + ", dateofbirth=" + dateofbirth + "]";
	}


	
		

}
