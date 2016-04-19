package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;

import com.logicq.logicq.common.LogicqHttpServletRequest;
import com.logicq.logicq.constant.EntityType;

public class UserProfilesRequest extends LogicqHttpServletRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserVO userVO;
	private EntityType entityType;
	private String area;

	public EntityType getEntityType() {

		return entityType;
	}

	public String getArea() {

		return area;
	}

	public void setEntityType(EntityType entityType) {

		this.entityType = entityType;
	}

	public void setArea(String area) {

		this.area = area;
	}
}
