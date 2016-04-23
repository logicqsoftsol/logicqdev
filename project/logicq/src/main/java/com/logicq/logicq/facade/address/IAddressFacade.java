package com.logicq.logicq.facade.address;

import java.util.List;

import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.user.User;

public interface IAddressFacade {

	public List<Address> getAddress();

	public List<User> getAddressList();

	List<EntityRole> getEntity();
}
/**
 * NIHAR 20-Mar-2016 11:51:34 pm
 */
