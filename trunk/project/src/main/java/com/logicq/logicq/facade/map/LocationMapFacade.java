package com.logicq.logicq.facade.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.conversion.address.AddressConversion;
import com.logicq.logicq.model.map.LocationMap;
import com.logicq.logicq.service.map.ILocationMapService;
import com.logicq.logicq.ui.address.vo.AddressVO;

public class LocationMapFacade implements ILocationMapFacade {

	@Autowired
	ILocationMapService locationMapService;
	AddressConversion addressConversion=AddressConversion.getInstance();
	
	public ILocationMapService getLocationMapService() {
		return locationMapService;
	}

	public void setLocationMapService(ILocationMapService locationMapService) {
		this.locationMapService = locationMapService;
	}

	@Transactional(readOnly = true)
	public AddressVO getLocation(String ipAddress) {
		LocationMap l_locationMap=locationMapService.getLocation(ipAddress);
		return addressConversion.conversionFromEntitytoVO(l_locationMap, new AddressVO());
		 
	}

}
