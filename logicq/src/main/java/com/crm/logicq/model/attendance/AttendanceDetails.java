package com.crm.logicq.model.attendance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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



	
	@EmbeddedId
	private Attendancekey  key;

	
	@Column(name = "IN_TIME",nullable = true)
	private String intime;
	
	@Column(name = "OUT_TIME", nullable = true)
	private String outtime;
	
	@Column(name = "IS_PRESENT", nullable = false)
	private String isPresent;

	@Column(name = "MOBILE", nullable = true)
	private String mobile;
	
	@Column(name = "FULL_NAME", nullable = true)
	private String fullName;
	
	
	@Column(name = "CLASS_NAME", nullable = true)
	private String classname;
	
	@Column(name = "SECTION_NAME", nullable = true)
	private String sectionname;
	
	@Column(name = "ATTENDANCE_FOR", nullable = false)
	private String attendancefor;
	
	
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

	public String getIsPresent() {
		return isPresent;
	}

	public void setIsPresent(String isPresent) {
		this.isPresent = isPresent;
	}

	public Attendancekey getKey() {
		return key;
	}

	public void setKey(Attendancekey key) {
		this.key = key;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	@Override
	public String toString() {
		return "AttendanceDetails [key=" + key + ", intime=" + intime + ", outtime=" + outtime + ", isPresent="
				+ isPresent + ", mobile=" + mobile + ", fullName=" + fullName + ", classname=" + classname
				+ ", sectionname=" + sectionname + ", attendancefor=" + attendancefor + "]";
	}

	
	
	
}
