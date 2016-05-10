package com.logicq.logicq.ui.search.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.service.search.IUserSearchService;
import com.logicq.logicq.ui.search.bean.UserSearchBean;
import com.logicq.logicq.ui.search.vo.UserSearchVO;

public class UserSearchBeanHelper {

	@Autowired
	IUserSearchService userSearchService;


	public UserSearchVO searchUsers(UserSearchBean usersearchbean) {
		UserSearchVO uservo=new UserSearchVO();
		convertBeanTOvo(usersearchbean,uservo);
		return userSearchService.searchUsers(uservo);
	}

	
	
	public UserSearchVO convertBeanTOvo(UserSearchBean usersearchbean,UserSearchVO usesearchvo ) {
		usesearchvo.setSearchText(usersearchbean.getSearchText());
		usesearchvo.setSearchlocation(usersearchbean.getSearchlocation());
		return usesearchvo;
	}
}
