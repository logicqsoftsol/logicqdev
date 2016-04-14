package com.logicq.logicq.service.address.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.dao.address.IAddressDAO;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.service.address.IAddressService;

public class AddressService implements IAddressService {
	@Autowired
	IAddressDAO addressDAO;
	
    public IAddressDAO getAddressDAO() {
    
    	return addressDAO;
    }

	
    public void setAddressDAO(IAddressDAO addressDAO) {
    
    	this.addressDAO = addressDAO;
    }


	public List<Address> getAddress() {

	    // TODO Auto-generated method stub
		return addressDAO.getAddress();
    }


	public List<EntityRole> getEntity() {

	    // TODO Auto-generated method stub
		return addressDAO.getEntity();
    }

	 
}
/**
 * NIHAR 20-Mar-2016 11:55:18 pm
 */
