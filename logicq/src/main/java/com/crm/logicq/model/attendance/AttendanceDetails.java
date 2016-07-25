package com.crm.logicq.model.attendance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.crm.logicq.model.user.User;

@Entity
@Table(name = "ATTENDANCE_REPORT")
public class AttendanceDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4648837621536487884L;



	@Id
    @Column(name = "ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE")
	private  Date  date;
	
	@Column(name = "IN_TIME",nullable = true)
	private String intime;
	
	@Column(name = "OUT_TIME", nullable = true)
	private String outtime;
	
	@Column(name = "IS_PRESENT", nullable = false)
	private boolean isPresent;

	@Column(name = "MOBILE", nullable = true)
	private String mobile;
	
	@Column(name = "FULL_NAME", nullable = true)
	private String fullName;
	
	@Column(name = "IDENTIFICATION_ID", nullable = true)
	private String idetificationid;
	
	@Column(name = "ATTENDANCE_FOR", nullable = false)
	private String attendancefor;
	
	
	
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

	public String getAttendancefor() {
		return attendancefor;
	}

	public void setAttendancefor(String attendancefor) {
		this.attendancefor = attendancefor;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}
	

	@Override
	public String toString() {
		return "AttendanceDetails [id=" + id +", date=" + date + ", intime=" + intime + ", outtime="
				+ outtime + ", isPresent=" + isPresent + ", mobile=" + mobile + ", fullName=" + fullName
				+ ", idetificationid=" + idetificationid + ", attendancefor=" + attendancefor + "]";
	}

	
	
}
