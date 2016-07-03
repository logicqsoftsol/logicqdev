package com.crm.logicq.model.attendance;

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
@Table(name = "ATTENDANCE_DETAILS")
public class AttendanceDetails {
	
	@Id
    @Column(name = "ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = true)
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE")
	private  Date  date;
	
	@Column(name = "IN_TIME",nullable = true)
	private String intime;
	
	@Column(name = "OUT_TIME", nullable = true)
	private String outtime;
	
	@Column(name = "IS_PRESENT", nullable = false)
	private boolean isPresent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "AttendanceDetails [id=" + id + ", user=" + user + ", date=" + date + ", intime=" + intime + ", outtime="
				+ outtime + ", isPresent=" + isPresent + "]";
	}

	
	
}
