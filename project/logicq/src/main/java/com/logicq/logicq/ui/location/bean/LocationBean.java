package com.logicq.logicq.ui.location.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.common.LogicqStringFormatter;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.location.Location;

/**
 * NIHAR 26-Jan-2016 5:49:54 pm
 */
@ManagedBean(name = "locationMB")
@SessionScoped
public class LocationBean {

	List<String> list;
	List<String> entitylist;

	public List<String> getEntitylist() {

		return entitylist;
	}

	public List<String> getList() {

		return list;
	}

	private Long locationId;
	private String locationName;

	public LocationBean() {

		list = getLocation();
		entitylist=getEntity();
	}

	public Long getLocationId() {

		return locationId;
	}

	public void setLocationId(Long locationId) {

		this.locationId = locationId;
	}

	public String getLocationName() {

		return locationName;
	}

	public void setLocationName(String locationName) {

		this.locationName = locationName;
	}

	public List<String> getLocation() {

		LocationManageBean locationManageBean = LogicqContextProvider.getApplicationContext().getBean(LocationManageBean.class);
		return locationManageBean.getLocation();
	}

	public List<String> getEntity() {

		LocationManageBean locationManageBean = LogicqContextProvider.getApplicationContext().getBean(LocationManageBean.class);
		return locationManageBean.getEntity();
	}
}
