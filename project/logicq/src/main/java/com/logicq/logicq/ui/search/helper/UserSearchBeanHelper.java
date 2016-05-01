package com.logicq.logicq.ui.search.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.service.search.IUserSearchService;
import com.logicq.logicq.ui.search.bean.UserSearchBean;
import com.logicq.logicq.ui.search.vo.UserSearchRequest;
import com.logicq.logicq.ui.search.vo.UserSearchResponse;
import com.logicq.logicq.ui.search.vo.UserSearchVO;
import com.logicq.logicq.ui.user.bean.ProfileBean;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserSearchBeanHelper {

	@Autowired
	IUserSearchService userSearchFacade;


	public UserSearchResponse searchUsers(UserSearchRequest userSearchRequest, UserSearchResponse userSearchResponse) {
		return userSearchFacade.searchUsers(userSearchRequest, userSearchResponse);
	}

	public UserSearchVO convertUserBeanToVO(UserSearchBean bean, UserSearchVO vo) {

		vo.setCity(bean.getCity());
		vo.setCountry(bean.getCountry());
		vo.setLandmarkname(bean.getLandmarkname());
		vo.setLocalityname(bean.getLocalityname());
		vo.setPincode(bean.getPincode());
		vo.setState(bean.getState());
		vo.setStreetname(bean.getStreetname());
		return null;
	}
	
	public ProfileBean convertUserBeanToVO(UserVO uservo,ProfileBean profilebean ) {
		
		profilebean.setFullname(uservo.getName());
		profilebean.setProfileid(String.valueOf(uservo.getId()));
		//profilebean.set
		
		return profilebean;
	}
}
