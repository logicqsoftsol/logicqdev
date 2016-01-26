package com.logicq.logicq.ui.address.bean;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.address.helper.AddressHelper;
import com.logicq.logicq.ui.address.vo.AddressVO;
import com.logicq.logicq.ui.user.vo.UserVO;

public class AddressManagedBean {

	
	
	public String getLocation(AddressVO p_addressvo) {
		AddressHelper addressbeanhelper=LogicqContextProvider.getApplicationContext().getBean(AddressHelper.class);
		UserVO l_uservo=LogicqContextProvider.getApplicationContext().getBean(UserVO.class);
		addressbeanhelper.getLocation(l_uservo.getIpaddress());
		return "sucess";
	}
}
