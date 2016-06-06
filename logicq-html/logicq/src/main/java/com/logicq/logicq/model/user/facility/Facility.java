package com.logicq.logicq.model.user.facility;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicq.logicq.common.ConvertClass;
import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.constant.EntityType;
import com.logicq.logicq.model.user.UserConstant;

@ConvertClass(enable=true)
@Entity
@Table(name = "USER_FACILITIES")
public class Facility extends BaseEntity implements UserConstant, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "facility_id", unique = true, nullable = false)
	private Long facilityId;
	@Column(name = "facility_name", unique = true, nullable = true)
	private String facilityName;
	@Column(name = "facility_Image_Id", unique = true, nullable = true)
	private String facilityImageId;
	@Column(name = "facility_Image_Path", unique = true, nullable = true)
	private String facilityImagePath;
	
	@Column(name = "ENTITY_TYPE", nullable = true)
	@Enumerated(EnumType.STRING)
	private EntityType entityType;
	
	public String getFacilityImageId() {

		return facilityImageId;
	}

	public String getFacilityImagePath() {

		return facilityImagePath;
	}

	public void setFacilityImageId(String facilityImageId) {

		this.facilityImageId = facilityImageId;
	}

	public void setFacilityImagePath(String facilityImagePath) {

		this.facilityImagePath = facilityImagePath;
	}

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

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	@Override
	public String toString() {
		return "Facility [facilityId=" + facilityId + ", facilityName=" + facilityName + ", facilityImageId="
				+ facilityImageId + ", facilityImagePath=" + facilityImagePath + ", entityType=" + entityType + "]";
	}

	
}
