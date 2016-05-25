package com.logicq.logicq.dao.address;

import java.util.List;

import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.ui.search.vo.BaseSearchVO;

public interface IAddressDAO {
	public void addAddress(Address location);
	public void updateAddress(Address location);
	public void deleteAddress(Address location);
	public List<Address> getAddress();
	public List<EntityRole> getEntity();
	
	public List<Address> getListofAllAddressandBasicUserinfo();
}
