package com.logicq.logicq.dao.location;

import java.util.List;

import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.location.Location;
import com.logicq.logicq.model.user.User;

public interface ILocationDAO {
	public void addLocation(Location location);
	public void updateLocation(Location location);
	public void deleteLocation(Location location);
	public List<Location> getLocation();
	public List<EntityRole> getEntity();
}
