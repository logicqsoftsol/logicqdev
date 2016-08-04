package com.crm.logicq.model.attendance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Attendancekey  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3742452977844062448L;

	@Temporal(TemporalType.DATE)
	@Column(name = "ATTD_DATE")
	private  Date  date;
	
	@Column(name = "IDENTIFICATION_ID", nullable = true)
	private String idetificationid;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getIdetificationid() {
		return idetificationid;
	}

	public void setIdetificationid(String idetificationid) {
		this.idetificationid = idetificationid;
	}

	@Override
	public String toString() {
		return "Attendancekey [date=" + date + ", idetificationid=" + idetificationid + "]";
	}
	
	

}
