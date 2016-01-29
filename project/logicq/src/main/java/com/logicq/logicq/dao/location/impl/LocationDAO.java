package com.logicq.logicq.dao.location.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.logicq.logicq.common.criteriamanager.LogicqCriteriaHandler;
import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.location.ILocationDAO;
import com.logicq.logicq.model.location.Location;

@Repository
public class LocationDAO extends AbstractDAO<Location> implements ILocationDAO{
	public LocationDAO(){
		System.out.println("locationdao constructor");
	}

	public void addLocation(Location location) {

	    // TODO Auto-generated method stub
	    
    }

	public void updateLocation(Location location) {

	    // TODO Auto-generated method stub
	    
    }

	public void deleteLocation(Location location) {

	    // TODO Auto-generated method stub
	    
    }

	public List<String> getLocation() {
	/*	LogicqCriteriaHandler l_crietria = new LogicqCriteriaHandler();
		Criteria criteria=l_crietria.createCriteria(getSession(), Location.class);
		criteria.setProjection(Projections.property("locationName"));
		List<Location> locationlist = criteria.list();*/
		String columns[]={"locationName"};
		List<String> locationlist=executeCriteriaForSingleColumn(Location.class,columns);
		

	    // TODO Auto-generated method stub
	    return locationlist;
    }
	
	 
	
}
