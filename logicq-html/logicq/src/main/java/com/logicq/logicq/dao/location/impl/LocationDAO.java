package com.logicq.logicq.dao.location.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.location.ILocationDAO;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.location.Location;

@Repository
public class LocationDAO extends AbstractDAO<Location> implements ILocationDAO {

	public void addLocation(Location location) {

		// TODO Auto-generated method stub
	}

	public void updateLocation(Location location) {

		// TODO Auto-generated method stub
	}

	public void deleteLocation(Location location) {

		// TODO Auto-generated method stub
	}

	public List<Location> getLocation() {

		List<Location> locationlist = (List<Location>) loadClass(Location.class);
		// TODO Auto-generated method stub
		return locationlist;
	}
	public List<EntityRole> getEntity() {

		List<EntityRole> entitylist = (List<EntityRole>)loadClass(EntityRole.class);
		// TODO Auto-generated method stub
		return entitylist;
	}
}
