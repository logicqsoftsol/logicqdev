package com.logicq.logicq.ui.login.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.facade.location.ILocationFacade;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.location.Location;

/**
 * NIHAR 30-Jan-2016 1:08:27 am
 */
public class LocationBeanHelper {

	@Autowired
	ILocationFacade locationFacade;

	public ILocationFacade getLocationFacade() {

		return locationFacade;
	}

	public void setLocationFacade(ILocationFacade locationFacade) {

		this.locationFacade = locationFacade;
	}

	public List<Location> getLocation() {

		return locationFacade.getLocation();
	}

	public List<EntityRole> getEntity() {

		// TODO Auto-generated method stub
		return locationFacade.getEntity();
	}
}
