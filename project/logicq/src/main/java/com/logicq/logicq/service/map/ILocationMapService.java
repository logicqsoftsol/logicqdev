package com.logicq.logicq.service.map;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.model.map.LocationMap;

public interface ILocationMapService {
	
	@ExceptionHandler(Exception.class)
	LocationMap getLocation(String ipAddress);

}
