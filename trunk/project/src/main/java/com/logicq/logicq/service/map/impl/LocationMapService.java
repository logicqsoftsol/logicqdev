package com.logicq.logicq.service.map.impl;

import com.logicq.logicq.dao.map.ILocationMapDAO;
import com.logicq.logicq.model.map.LocationMap;
import com.logicq.logicq.service.map.ILocationMapService;

public class LocationMapService implements ILocationMapService {

	ILocationMapDAO locationMapDAO;
	LocationMap locationMap;
	public LocationMap getLocation(String ipAddress) {
		try {
			locationMap=locationMapDAO.getLocation(ipAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return locationMap;
	}

	public ILocationMapDAO getLocationMapDAO() {
		return locationMapDAO;
	}

	public void setLocationMapDAO(ILocationMapDAO locationMapDAO) {
		this.locationMapDAO = locationMapDAO;
	}

}
