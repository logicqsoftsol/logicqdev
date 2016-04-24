package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;

public class ProfileVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5327969218733890388L;
	private Integer userid;
	private String fullname;
	private String profileimage;
	private String profileid;
	private EducationVO educationdetails;

	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	public String getProfileid() {
		return profileid;
	}
	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}
	public EducationVO getEducationdetails() {
		return educationdetails;
	}
	public void setEducationdetails(EducationVO educationdetails) {
		this.educationdetails = educationdetails;
	}



}
