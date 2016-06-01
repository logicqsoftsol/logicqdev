package com.logicq.logicq.controller.search;

import java.util.ArrayList;
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

import com.logicq.logicq.constant.EntityType;
import com.logicq.logicq.model.common.DropdownData;
import com.logicq.logicq.service.address.IAddressService;
import com.logicq.logicq.service.search.IUserSearchService;
import com.logicq.logicq.service.search.common.ISearchService;
import com.logicq.logicq.ui.search.vo.BaseSearchVO;
import com.logicq.logicq.ui.search.vo.UserSearchVO;
import com.logicq.logicq.ui.user.vo.UserVO;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	IAddressService addressservice;

	@Autowired
	ISearchService searchservice;

	@RequestMapping(value = "/user/getAlluserforlocation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserVO>> getAlluserforlocation() {
		UserSearchVO luser = new UserSearchVO();
		// luser.setCity("pune");
		luser.setSearchText("DOCTOR");
		UserSearchVO uservo = null;// usersearch.searchUsers(luser);
		List<UserVO> user = null;// uservo.getUservo();
		if (null == user || user.isEmpty()) {
			new ResponseEntity<List<UserVO>>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<UserVO>>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAlllocations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DropdownData>> getAllLocationOptioon() {
		List<DropdownData> locationlist = searchservice.search("location");
		return new ResponseEntity<List<DropdownData>>(locationlist, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllEntites", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DropdownData>> getEntites() {
		List<DropdownData> entities = searchservice.search("entity");
		return new ResponseEntity<List<DropdownData>>(entities, HttpStatus.OK);
	}

}
