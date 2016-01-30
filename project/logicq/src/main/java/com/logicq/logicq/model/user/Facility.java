package com.logicq.logicq.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_FACILITIES")
public class Facility {

	@Id
	@Column(name = "facility_id", unique = true, nullable = false)
	private Long facilityId;
	@Column(name = "facility_name", unique = true, nullable = false)
	private String facilityName;

	public Long getFacilityId() {

		return facilityId;
	}

	public void setFacilityId(Long facilityId) {

		this.facilityId = facilityId;
	}

	public String getFacilityName() {

		return facilityName;
	}

	public void setFacilityName(String facilityName) {

		this.facilityName = facilityName;
	}
}
