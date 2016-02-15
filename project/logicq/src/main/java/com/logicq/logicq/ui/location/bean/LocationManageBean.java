package com.logicq.logicq.ui.location.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.common.LogicqStringFormatter;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.location.Location;
import com.logicq.logicq.ui.login.helper.LocationBeanHelper;

public class LocationManageBean {

	@Autowired
	LocationBeanHelper locationBeanHelper;

	public LocationBeanHelper getLocationBeanHelper() {

		return locationBeanHelper;
	}

	public void setLocationBeanHelper(LocationBeanHelper locationBeanHelper) {

		this.locationBeanHelper = locationBeanHelper;
	}

	public List<String> getLocation() {

		List<Location> locationlist = null;
		locationlist = null;//locationBeanHelper.getLocation();
		return null;// LogicqStringFormatter.convertAutoCompleteFormat(locationlist);
	}
	public List<String> getEntity() {
		List<EntityRole> entitylist = null;
		entitylist = locationBeanHelper.getEntity();
		// TODO Auto-generated method stub
		return LogicqStringFormatter.convertAutoCompleteFormatEntity(entitylist);
	}
	public List<String> getAllLocation() {

		List<Location> latlist = null;
		latlist = locationBeanHelper.getLocation();
		return LogicqStringFormatter.convertAutoCompleteFormatLat(latlist);
	}
}
/**
 * NIHAR 28-Jan-2016 12:10:49 am
 */
