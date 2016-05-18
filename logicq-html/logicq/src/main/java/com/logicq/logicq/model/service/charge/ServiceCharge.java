package com.logicq.logicq.model.service.charge;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.model.user.User;

@Entity
@Table(name = "SERVICE_CHARGE")
public class ServiceCharge extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5768241881564357271L;
	

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long servicechargeid;
	
	@Column(name = "CHARGE_AMT",nullable = true)
	private Double chargeamount;
	
	@Column(name = "CHARGE_CURRENCY",nullable = true)
	private String chargecurrency;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private User user;
	
	@Column(name = "FACILITY_ID",nullable = true)
	private Long facilityid;
	


	public Long getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(Long facilityid) {
		this.facilityid = facilityid;
	}

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
