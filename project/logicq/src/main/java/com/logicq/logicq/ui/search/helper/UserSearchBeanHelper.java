package com.logicq.logicq.ui.search.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.facade.search.IUserSearchFacade;
import com.logicq.logicq.ui.search.bean.UserSearchBean;
import com.logicq.logicq.ui.search.vo.UserSearchRequest;
import com.logicq.logicq.ui.search.vo.UserSearchResponse;
import com.logicq.logicq.ui.search.vo.UserSearchVO;

public class UserSearchBeanHelper {

	@Autowired
	IUserSearchFacade userSearchFacade;

	public IUserSearchFacade getUserSearchFacade() {

		return userSearchFacade;
	}

	public void setUserSearchFacade(IUserSearchFacade userSearchFacade) {

		this.userSearchFacade = userSearchFacade;
	}

	public UserSearchResponse searchUsers(UserSearchRequest userSearchRequest, UserSearchResponse userSearchResponse) {

		return (userSearchFacade.searchUsers(userSearchRequest, userSearchResponse));
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
}
