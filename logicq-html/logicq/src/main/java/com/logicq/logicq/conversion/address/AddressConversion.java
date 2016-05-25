package com.logicq.logicq.conversion.address;

import java.util.ArrayList;
import java.util.List;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.common.LogicqConversion;
import com.logicq.logicq.conversion.user.UserConversion;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.map.LocationMap;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.ui.address.vo.AddressVO;
import com.logicq.logicq.ui.search.vo.BaseSearchVO;
import com.logicq.logicq.ui.user.vo.UserVO;


public class AddressConversion {
	
	private static AddressConversion instance;
	private UserConversion userconversion;

	public static AddressConversion getInstance() {
		if (null == instance) {
			instance = new AddressConversion();
		}
		return instance;
	}

	/*
	 * 
	 */
	public static List<Address> conversionFromVOtoEntity(List<AddressVO> addressvolist, Class claz) {
		return (List<Address>) LogicqConversion.objectConversionForList(addressvolist, Address.class);
	}

	/**
	 * 
	 * @param user
	 * @param userVO
	 * @return
	 */
	public static List<AddressVO> conversionFromEntitytoVO(List<Address> addresslist, Class claz) {
		return (List<AddressVO>) LogicqConversion.objectConversionForList(addresslist, AddressVO.class);
	}
	

	
}
