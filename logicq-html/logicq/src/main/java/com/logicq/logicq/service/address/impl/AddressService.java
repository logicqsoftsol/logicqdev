package com.logicq.logicq.service.address.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.logicq.logicq.ui.search.vo.BaseSearchVO;

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


	public List<BaseSearchVO> getListofAllAddressandBasicUserinfo() {
		List<Address> address = addressDAO.getListofAllAddressandBasicUserinfo();
		List<BaseSearchVO> addresslist = new ArrayList<BaseSearchVO>();

		for (Address addr : address) {
			BaseSearchVO basesearch = new BaseSearchVO();
			basesearch.setAddressid(addr.getAddressId());
			basesearch.setCity(addr.getCity());
			basesearch.setCountry(addr.getCountry());
			basesearch.setLatitude(addr.getLatitude());
			basesearch.setLongitude(addr.getLongitude());
			basesearch.setFirstname(addr.getUser().getFirstName());
			basesearch.setLastname(addr.getUser().getLastName());
			basesearch.setEntityType(addr.getUser().getEntityType());
			
			addresslist.add(basesearch);
		}
		return addresslist;
	}
}