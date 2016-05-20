package com.logicq.logicq.dao.address.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.address.IAddressDAO;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;

@Repository
public class AddressDAO extends AbstractDAO<Address> implements IAddressDAO {

	public void addAddress(Address address) {
	}

	public void updateAddress(Address address) {

		
	}

	public void deleteAddress(Address address) {

	
	}

	public List<EntityRole> getEntity() {
		List<EntityRole> entitylist = (List<EntityRole>) loadClass(EntityRole.class);
		return entitylist;
	}

	 
	public List<Address> getAddress() {
		List<Address> locationlist = (List<Address>) loadClass(Address.class);
		return locationlist;
	}
}