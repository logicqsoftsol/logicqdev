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

		// TODO Auto-generated method stub
	}

	public void updateAddress(Address address) {

		// TODO Auto-generated method stub
	}

	public void deleteAddress(Address address) {

		// TODO Auto-generated method stub
	}

	public List<EntityRole> getEntity() {

		List<EntityRole> entitylist = (List<EntityRole>) loadClass(EntityRole.class);
		// TODO Auto-generated method stub
		return entitylist;
	}

	 
	public List<Address> getAddress() {

		List<Address> locationlist = (List<Address>) loadClass(Address.class);
		// TODO Auto-generated method stub
		return locationlist;
	}
}
/**
 * NIHAR 20-Mar-2016 11:35:07 pm
 */
