package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;

public class ServiceChargeVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4351090101381894204L;
	
	private Long servicechargeid;
	
	private Double chargeamount;

	private String chargecurrency;

	public Long getServicechargeid() {
		return servicechargeid;
	}

	public void setServicechargeid(Long servicechargeid) {
		this.servicechargeid = servicechargeid;
	}

	public Double getChargeamount() {
		return chargeamount;
	}

	public void setChargeamount(Double chargeamount) {
		this.chargeamount = chargeamount;
	}

	public String getChargecurrency() {
		return chargecurrency;
	}

	public void setChargecurrency(String chargecurrency) {
		this.chargecurrency = chargecurrency;
	}
	
	

}
