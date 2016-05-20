package com.logicq.logicq.service.address.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.conversion.address.AddressConversion;
import com.logicq.logicq.dao.address.IAddressDAO;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.service.address.IAddressService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.address.vo.AddressVO;

@Service
@Transactional
public class AddressService implements IAddressService {
	
	@Autowired
	IAddressDAO addressDAO;
	
	@Autowired
	IUserService userService;
 

	public List<AddressVO> getAllAddress() {
		List<Address> address = addressDAO.getAddress();
		return AddressConversion.conversionFromEntitytoVO(address, AddressVO.class);
	}


	public List<EntityRole> getEntity() {
		return addressDAO.getEntity();
    }
	
	public List<User> getAddressList() {
		return userService.getUsers();
	}


	public String getListofAllAddress() {
		List<AddressVO> addresslist=	getAllAddress();
		 return addresslist.toString();
	}
}