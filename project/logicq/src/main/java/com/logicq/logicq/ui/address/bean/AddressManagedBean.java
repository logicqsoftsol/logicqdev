package com.logicq.logicq.ui.address.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.common.LogicqStringFormatter;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.location.Location;
import com.logicq.logicq.ui.address.helper.AddressHelper;
import com.logicq.logicq.ui.address.vo.AddressVO;
import com.logicq.logicq.ui.user.vo.UserVO;

public class AddressManagedBean {

	public String getLocation(AddressVO p_addressvo) {

		AddressHelper addressbeanhelper = LogicqContextProvider.getApplicationContext().getBean(AddressHelper.class);
		UserVO l_uservo = LogicqContextProvider.getApplicationContext().getBean(UserVO.class);
		addressbeanhelper.getLocation(l_uservo.getIpaddress());
		return "sucess";
	}

	public List<String> getAddress() {

		AddressHelper addressbeanhelper = LogicqContextProvider.getApplicationContext().getBean(AddressHelper.class);
		List<Address> addresslist = null;
		addresslist = addressbeanhelper.getAddress();
		return LogicqStringFormatter.convertAutoCompleteFormat(addresslist);
	}

	public List<String> getEntity() {

		AddressHelper addressbeanhelper = LogicqContextProvider.getApplicationContext().getBean(AddressHelper.class);
		List<EntityRole> entitylist = null;
		entitylist = addressbeanhelper.getEntity();
		// TODO Auto-generated method stub
		return LogicqStringFormatter.convertAutoCompleteFormatEntity(entitylist);
	}
	 public List<String> getAllLocation() {
		AddressHelper addressbeanhelper=LogicqContextProvider.getApplicationContext().getBean(AddressHelper.class);
		List<Address> latlist = null;
		latlist = addressbeanhelper.getAddress();
		return LogicqStringFormatter.convertAutoCompleteFormatLat(latlist);
	} 
}
