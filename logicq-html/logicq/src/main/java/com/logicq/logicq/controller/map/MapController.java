package com.logicq.logicq.controller.map;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.logicq.service.address.IAddressService;
import com.logicq.logicq.ui.address.vo.AddressVO;

@RestController
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	IAddressService addressservice;
	
	@RequestMapping(value = "/getAllLocation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AddressVO>> getAllReportData() {
		List<AddressVO> listaddressvo = addressservice.getAllAddress();
		return new ResponseEntity<List<AddressVO>>(listaddressvo, HttpStatus.OK);
	}

}
