package com.logicq.logicq.ui.location.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.common.LogicqStringFormatter;
import com.logicq.logicq.service.location.impl.LocationService;
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

		List<String> locationlist = null;
		//LocationService loc = LogicqContextProvider.getApplicationContext().getBean(LocationService.class);
		//locationlist = loc.getLocation();
		locationlist=locationBeanHelper.getLocation();
		return LogicqStringFormatter.convertAutoCompleteFormat(locationlist);
	}
}
/**
 * NIHAR 28-Jan-2016 12:10:49 am
 */
