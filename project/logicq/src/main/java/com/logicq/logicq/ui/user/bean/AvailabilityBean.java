package com.logicq.logicq.ui.user.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "avilabilityMB")
@ViewScoped
public class AvailabilityBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1214864930424592540L;
	
	private String avilabletime;
	
	private Integer appoitemntbookedcount;
	
	private Integer appoitmentavialblecount;
	
	private Integer appoitmentqueuecount;

	private Date avilablitydate;

	public String getAvilabletime() {
		return avilabletime;
	}

	public void setAvilabletime(String avilabletime) {
		this.avilabletime = avilabletime;
	}

	public Integer getAppoitemntbookedcount() {
		return appoitemntbookedcount;
	}

	public void setAppoitemntbookedcount(Integer appoitemntbookedcount) {
		this.appoitemntbookedcount = appoitemntbookedcount;
	}

	public Integer getAppoitmentavialblecount() {
		return appoitmentavialblecount;
	}

	public void setAppoitmentavialblecount(Integer appoitmentavialblecount) {
		this.appoitmentavialblecount = appoitmentavialblecount;
	}

	public Integer getAppoitmentqueuecount() {
		return appoitmentqueuecount;
	}

	public void setAppoitmentqueuecount(Integer appoitmentqueuecount) {
		this.appoitmentqueuecount = appoitmentqueuecount;
	}

	public Date getAvilablitydate() {
		return avilablitydate;
	}

	public void setAvilablitydate(Date avilablitydate) {
		this.avilablitydate = avilablitydate;
	}
}
