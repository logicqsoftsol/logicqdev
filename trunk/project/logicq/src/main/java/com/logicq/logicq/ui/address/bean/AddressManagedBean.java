package com.logicq.logicq.ui.address.bean;

import java.util.List;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.common.LogicqStringFormatter;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.ui.address.helper.AddressHelper;
import com.logicq.logicq.ui.address.vo.AddressVO;
import com.logicq.logicq.ui.user.vo.UserVO;

public class AddressManagedBean {


	public List<String> getAddress() {

		AddressHelper addressbeanhelper = LogicqContextProvider.getApplicationContext().getBean(AddressHelper.class);
		List<Address> addresslist = null;
		addresslist = addressbeanhelper.getAddress();
		return LogicqStringFormatter.convertAutoCompleteFormat(addresslist);
	}

	public List<String> getEntity() {

		AddressHelper addressbeanhelper = LogicqContextProvider.getApplicationContext().getBean(AddressHelper.class);
		List<EntityRole> entitylist =addressbeanhelper.getEntity();
		return LogicqStringFormatter.convertAutoCompleteFormatEntity(entitylist);
	}

	public List<String> getAllLocation() {
		AddressHelper addressbeanhelper = LogicqContextProvider.getApplicationContext().getBean(AddressHelper.class);
		List<User> latlist  = addressbeanhelper.getAddressList();
		return LogicqStringFormatter.convertAutoCompleteFormatLat(latlist);
	}
}
