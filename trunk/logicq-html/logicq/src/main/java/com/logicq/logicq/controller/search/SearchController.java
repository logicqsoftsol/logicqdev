package com.logicq.logicq.controller.search;

import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.logicq.service.address.IAddressService;
import com.logicq.logicq.service.search.IUserSearchService;
import com.logicq.logicq.ui.search.vo.BaseSearchVO;
import com.logicq.logicq.ui.search.vo.UserSearchVO;
import com.logicq.logicq.ui.user.vo.UserVO;


@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	IAddressService addressservice;
	
	@Autowired
	IUserSearchService usersearch;
	
	@RequestMapping(value = "/map/getAlllocation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BaseSearchVO>> getAllLocationOptioon() {
		List<BaseSearchVO> alladdressdetails = addressservice.getListofAllAddressandBasicUserinfo();
//		if (StringUtils.isEmpty(adressoption)) {
//			new ResponseEntity<BaseSearchVO>(adressoption, HttpStatus.BAD_REQUEST);
//		}
		return new ResponseEntity<List<BaseSearchVO>>(alladdressdetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/getAlluserforlocation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserVO>> getAlluserforlocation() {
		UserSearchVO luser = new UserSearchVO();
		//luser.setCity("pune");
		luser.setSearchText("DOCTOR");
		UserSearchVO uservo = usersearch.searchUsers(luser);
		List<UserVO> user = null;//uservo.getUservo();
		if (null == user || user.isEmpty()) {
			new ResponseEntity<List<UserVO>>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<UserVO>>(user, HttpStatus.OK);
	}

}
