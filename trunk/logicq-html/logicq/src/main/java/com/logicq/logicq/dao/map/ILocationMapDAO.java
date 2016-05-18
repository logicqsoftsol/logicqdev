package com.logicq.logicq.dao.map;

import com.logicq.logicq.model.map.LocationMap;

public interface ILocationMapDAO {
	
	LocationMap getLocation(String ipAddress) throws Exception;

}
