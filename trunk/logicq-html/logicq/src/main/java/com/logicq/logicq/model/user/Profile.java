package com.logicq.logicq.model.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.model.user.education.Education;

@Entity
@Table(name = "PROFILE")
public class Profile extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 596098087529285542L;
	
	@Id
	@Column(name = "PROFILE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profileid;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private User user;
	
	
	@Column(name = "PROFILE_IMAGE", unique = true, nullable = true)
	private String profileimage;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "profile",fetch = FetchType.LAZY)
	private Education educationdetails;

	public Long getProfileid() {
		return profileid;
	}

	public void setProfileid(Long profileid) {
		this.profileid = profileid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProfileimage() {
		return profileimage;
	}

	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}

	public Education getEducationdetails() {
		return educationdetails;
	}

	public void setEducationdetails(Education educationdetails) {
		this.educationdetails = educationdetails;
	}

}
