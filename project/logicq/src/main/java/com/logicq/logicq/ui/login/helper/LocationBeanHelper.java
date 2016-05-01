package com.logicq.logicq.ui.login.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.location.Location;
import com.logicq.logicq.service.location.ILocationService;

/**
 * NIHAR 30-Jan-2016 1:08:27 am
 */
public class LocationBeanHelper {

	@Autowired
	ILocationService locationService;

	

	public List<Location> getLocation() {

		return locationService.getLocation();
	}

	public List<EntityRole> getEntity() {

		// TODO Auto-generated method stub
		return locationService.getEntity();
	}
}
