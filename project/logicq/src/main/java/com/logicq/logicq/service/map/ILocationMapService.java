package com.logicq.logicq.service.map;

import com.logicq.logicq.model.map.LocationMap;

public interface ILocationMapService {
	
	LocationMap getLocation(String ipAddress);

}
