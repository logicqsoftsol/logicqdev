package com.logicq.logicq.service.address;

import java.util.List;

import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.ui.address.vo.AddressVO;

public interface IAddressService {

	public List<AddressVO> getAllAddress();

	public List<EntityRole> getEntity();
	
	public List<User> getAddressList();
}

