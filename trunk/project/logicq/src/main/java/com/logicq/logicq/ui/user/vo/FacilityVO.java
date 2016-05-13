package com.logicq.logicq.ui.user.vo;

import com.logicq.logicq.common.ConvertClass;

@ConvertClass(enable=true)
public class FacilityVO {

	private Integer facilityID;
	private String facilityName;
	private String facilityImagePath;
	private Integer userid;

	public Integer getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(Integer facilityID) {
		this.facilityID = facilityID;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFacilityName() {

		return facilityName;
	}

	public String getFacilityImagePath() {

		return facilityImagePath;
	}

	public void setFacilityName(String facilityName) {

		this.facilityName = facilityName;
	}

	public void setFacilityImagePath(String facilityImagePath) {

		this.facilityImagePath = facilityImagePath;
	}
}
