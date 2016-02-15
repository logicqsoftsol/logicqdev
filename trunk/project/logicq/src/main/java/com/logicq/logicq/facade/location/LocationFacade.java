package com.logicq.logicq.facade.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.location.Location;
import com.logicq.logicq.service.location.ILocationService;

public class LocationFacade implements ILocationFacade {

	@Autowired
	ILocationService locationService;

	public ILocationService getLocationService() {

		return locationService;
	}

	public void setLocationService(ILocationService locationService) {

		this.locationService = locationService;
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly = true)
	public List<Location> getLocation() {

		return locationService.getLocation();
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly = true)
	public List<EntityRole> getEntity() {

		return locationService.getEntity();
	}
}
/**
 * NIHAR 28-Jan-2016 12:06:15 am
 */
