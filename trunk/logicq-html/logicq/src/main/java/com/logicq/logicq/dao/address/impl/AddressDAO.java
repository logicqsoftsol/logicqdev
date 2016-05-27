package com.logicq.logicq.dao.address.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.address.IAddressDAO;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.ui.search.vo.BaseSearchVO;

@Repository
public class AddressDAO extends AbstractDAO<Address> implements IAddressDAO {

	private static final String STRATUP_ADDRESS_LOAD = "select distinct addr from Address addr inner join addr.user";

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
	
	@SuppressWarnings("unchecked")
	public List<Address> getListofAllAddressandBasicUserinfo() {
		String query =  STRATUP_ADDRESS_LOAD;
		return  (List<Address>) execcuteQuery(query);
	}
}