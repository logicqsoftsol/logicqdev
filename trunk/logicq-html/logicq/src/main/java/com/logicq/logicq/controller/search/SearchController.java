package com.logicq.logicq.controller.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.logicq.model.common.DropdownData;
import com.logicq.logicq.model.serviceprovider.SPBasic;
import com.logicq.logicq.service.address.IAddressService;
import com.logicq.logicq.service.search.common.ISearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	IAddressService addressservice;

	@Autowired
	ISearchService searchservice;

	@RequestMapping(value = "/serviceprovider/getAllSPforlocation/{location}/{entity}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SPBasic>> getAlluserforlocation(@PathVariable String location,@PathVariable String entity) {
		List<SPBasic> spbasic = new ArrayList<SPBasic>();
	   if(StringUtils.isEmpty(location)||StringUtils.isEmpty(entity) ){
		   new ResponseEntity<List<SPBasic>>(spbasic, HttpStatus.BAD_REQUEST);
	   }else{
		   spbasic= searchservice.searchServiceProvider(location, entity);
	   }
		
		
		return new ResponseEntity<List<SPBasic>>(spbasic, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAlllocations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DropdownData>> getAllLocationOptioon() {
		List<DropdownData> locationlist = searchservice.search("location");
		return new ResponseEntity<List<DropdownData>>(locationlist, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllEntites", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DropdownData>> getEntites() {
		
		//addressservice.getListofAllAddressandBasicUserinfo();
		List<DropdownData> entities = searchservice.search("entity");
		return new ResponseEntity<List<DropdownData>>(entities, HttpStatus.OK);
	}

}
