package com.logicq.logicq.facade.map;

import com.logicq.logicq.ui.address.vo.AddressVO;

public interface ILocationMapFacade {

	AddressVO getLocation(String ipAddress);
	
}
