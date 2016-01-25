package com.logicq.logicq.ui.address.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.facade.map.ILocationMapFacade;
import com.logicq.logicq.ui.address.bean.AddressBean;
import com.logicq.logicq.ui.address.vo.AddressVO;

public class AddressHelper {

	@Autowired
	ILocationMapFacade locationMapFacade;

	public ILocationMapFacade getLocationMapFacade() {
		return locationMapFacade;
	}

	public void setLocationMapFacade(ILocationMapFacade locationMapFacade) {
		this.locationMapFacade = locationMapFacade;
	}
	
	
	
	
	public AddressVO conversionUItoVO(AddressBean p_uibean, AddressVO p_address) {
		p_address.setBuldingnumber(p_uibean.getBuldingnumber());
		p_address.setCity(p_uibean.getCity());
		p_address.setState(p_uibean.getState());
		p_address.setStreetname(p_uibean.getStreetname());
		p_address.setCountry(p_uibean.getCountry());
		p_address.setFloornumber(p_uibean.getFloornumber());
		p_address.setEmail(p_uibean.getEmail());
		p_address.setLandmarkname(p_uibean.getLandmarkname());
		p_address.setHousenumber(p_uibean.getHousenumber());
		p_address.setLandphone(p_uibean.getLandphone());
		p_address.setLocalityname(p_uibean.getLocalityname());
		p_address.setMobilenumber(p_uibean.getMobilenumber());
		p_address.setPincode(p_uibean.getPincode());
		return p_address;
	}

	public AddressBean conversionVOtoUI(AddressVO p_address,AddressBean p_uibean ) {
		p_uibean.setBuldingnumber(p_address.getBuldingnumber());
		p_uibean.setCity(p_address.getCity());
		p_uibean.setState(p_address.getState());
		p_uibean.setStreetname(p_address.getStreetname());
		p_uibean.setCountry(p_address.getCountry());
		p_uibean.setFloornumber(p_address.getFloornumber());
		p_uibean.setEmail(p_address.getEmail());
		p_uibean.setLandmarkname(p_address.getLandmarkname());
		p_uibean.setHousenumber(p_address.getHousenumber());
		p_uibean.setLandphone(p_address.getLandphone());
		p_uibean.setLocalityname(p_address.getLocalityname());
		p_uibean.setMobilenumber(p_address.getMobilenumber());
		p_uibean.setPincode(p_address.getPincode());
		return p_uibean;
	}
	
	public void getLocation(String ip_address){
		 locationMapFacade.getLocation(ip_address);
	}
}
