package com.logicq.logicq.facade.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
    public List<String> getLocation(){
    	return locationService.getLocation();
    }
	
	
}
/**
 * NIHAR 28-Jan-2016 12:06:15 am
 */
