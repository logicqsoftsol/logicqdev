package com.logicq.logicq.conversion.address;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.model.map.LocationMap;
import com.logicq.logicq.ui.address.vo.AddressVO;


public class AddressConversion {
	
	private static AddressConversion instance;

	public static AddressConversion getInstance() {
		if (null == instance) {
			instance = new AddressConversion();
		}
		return instance;
	}


	public LocationMap conversionFromVOtoEntity(AddressVO p_addressvo, LocationMap p_location) {
		
		return p_location;
	}

	public AddressVO conversionFromEntitytoVO(LocationMap p_location, AddressVO p_addressvo) {
		
		return p_addressvo;
	}

	public LocationMap handleConversionVOtoEntityWithContext( AddressVO p_addressvo) {
		LocationMap locationmap = null;
		if (null != LogicqContextProvider.getApplicationContext()) {
			locationmap = LogicqContextProvider.getApplicationContext().getBean(
					LocationMap.class);
		}
		if(null==locationmap){
			locationmap=new LocationMap();
		}
		return conversionFromVOtoEntity(p_addressvo, locationmap);
	}
	
	
	public AddressVO handleConversionEntitytoVOWithContext(LocationMap p_location) {
		AddressVO l_addressvo = null;
		if (null != LogicqContextProvider.getApplicationContext()) {
			l_addressvo = LogicqContextProvider.getApplicationContext().getBean(
					AddressVO.class);
		}
		if(null==l_addressvo){
			l_addressvo=new AddressVO();
		}
		return  conversionFromEntitytoVO(p_location, l_addressvo);
	}
	
	
}
