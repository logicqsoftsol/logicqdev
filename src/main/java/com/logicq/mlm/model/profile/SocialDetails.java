package com.logicq.mlm.model.profile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SOCIAL_DETAILS")
public class SocialDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 868552591757208866L;

	@Id
	@Column(name = "SOCIAL_ID")
	private String contactid;

	@Column(name = "FB_LINK")
	private String fblink;

	@Column(name = "YT_LINK")
	private String youtubelink;

	@Column(name = "TWITER_LINK")
	private String twiter;

	@Column(name = "LIN_LINK")
	private String linkedinlink;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "PROFILE_ID")
	private UserProfile userprofile;

	public String getContactid() {
		return contactid;
	}

	public void setContactid(String contactid) {
		this.contactid = contactid;
	}

	public String getFblink() {
		return fblink;
	}

	public void setFblink(String fblink) {
		this.fblink = fblink;
	}

	public String getYoutubelink() {
		return youtubelink;
	}

	public void setYoutubelink(String youtubelink) {
		this.youtubelink = youtubelink;
	}

	public String getTwiter() {
		return twiter;
	}

	public void setTwiter(String twiter) {
		this.twiter = twiter;
	}

	public String getLinkedinlink() {
		return linkedinlink;
	}

	public void setLinkedinlink(String linkedinlink) {
		this.linkedinlink = linkedinlink;
	}

	public UserProfile getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UserProfile userprofile) {
		this.userprofile = userprofile;
	}

	@Override
	public String toString() {
		return "SocialDetails [contactid=" + contactid + ", fblink=" + fblink + ", youtubelink=" + youtubelink
				+ ", twiter=" + twiter + ", linkedinlink=" + linkedinlink + "]";
	}

	
	
}
