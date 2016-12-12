package com.logicq.mlm.model.performance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_NETWORK_COUNT")
public class UserNetworkCount {
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "PROFILE_ID", unique = true, nullable = false)
	private Long profileid;
	
	@Column(name = "MEMBER_ID", unique = true, nullable = false)
	private String memberid;
	

	@Column(name = "LEVEL", unique = true, nullable = false)
	private String networklevel;
	
	@Column(name = "TOTAL_MEMEBER_COUNT", unique = true, nullable = false)
	private String membercount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProfileid() {
		return profileid;
	}

	public void setProfileid(Long profileid) {
		this.profileid = profileid;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getNetworklevel() {
		return networklevel;
	}

	public void setNetworklevel(String networklevel) {
		this.networklevel = networklevel;
	}

	public String getMembercount() {
		return membercount;
	}

	public void setMembercount(String membercount) {
		this.membercount = membercount;
	}

	@Override
	public String toString() {
		return "UserNetworkCount [id=" + id + ", profileid=" + profileid + ", memberid=" + memberid + ", networklevel="
				+ networklevel + ", membercount=" + membercount + "]";
	}
	
	
	
}
