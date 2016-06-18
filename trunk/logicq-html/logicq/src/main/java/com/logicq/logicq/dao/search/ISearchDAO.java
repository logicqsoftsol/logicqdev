package com.logicq.logicq.dao.search;

import java.util.List;

import com.logicq.logicq.model.common.DropdownData;
import com.logicq.logicq.model.user.User;

public interface ISearchDAO {
	
	public List<DropdownData> search(String searchfor);
	public List<DropdownData> searchSpecialisation(String searchfor);
	public List<User> searchServiceProvider(String location,String entitype);

}
