 
package com.logicq.logicq.facade.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.service.address.IAddressService;


public class AddressFacade implements IAddressFacade {
	@Autowired
	IAddressService addressService;

	
    public IAddressService getAddressService() {
    
    	return addressService;
    }

	
    public void setAddressService(IAddressService addressService) {
    
    	this.addressService = addressService;
    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly = true)
	public List<Address> getAddress() {

		return addressService. getAddress();
	     
    }
    @Transactional(propagation=Propagation.SUPPORTS,readOnly = true)
	public List<EntityRole> getEntity() {

		return  addressService.getEntity();
	    
    }
}


/**
NIHAR
20-Mar-2016
11:51:24 pm
*/