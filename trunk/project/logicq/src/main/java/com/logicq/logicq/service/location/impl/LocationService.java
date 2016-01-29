package com.logicq.logicq.service.location.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.dao.location.ILocationDAO;
import com.logicq.logicq.service.location.ILocationService;
import com.logicq.logicq.service.login.IloginService;

public class LocationService implements ILocationService{

	@Autowired
	ILocationDAO locationDAO;

	public ILocationDAO getLocationDAO() {

		return locationDAO;
	}

	public void setLocationDAO(ILocationDAO locationDAO) {

		this.locationDAO = locationDAO;
	}

	public List<String> getLocation() {

		/*List<String> locationlist = null;
		if (null != locationDAO) {
			locationlist = locationDAO.getLocation();
		}*/
		
		return locationDAO.getLocation();
	}
}
