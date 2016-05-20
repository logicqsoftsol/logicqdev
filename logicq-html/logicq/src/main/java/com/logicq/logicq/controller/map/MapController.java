package com.logicq.logicq.controller.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.logicq.service.address.IAddressService;

@RestController
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	IAddressService addressservice;
	
	@RequestMapping(value = "/getAllLocation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllLocationOptioon() {
		String adressoption = addressservice.getListofAllAddress();
		if (StringUtils.isEmpty(adressoption)) {
			new ResponseEntity<String>(adressoption, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(adressoption, HttpStatus.OK);
	}

}
