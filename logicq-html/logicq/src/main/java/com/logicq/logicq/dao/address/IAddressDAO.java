package com.logicq.logicq.dao.address;

import java.util.List;

import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;

public interface IAddressDAO {
	public void addAddress(Address location);
	public void updateAddress(Address location);
	public void deleteAddress(Address location);
	public List<Address> getAddress();
	public List<EntityRole> getEntity();
}
/**
 * NIHAR 20-Mar-2016 11:38:10 pm
 */
