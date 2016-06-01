package com.logicq.logicq.dao.search;

import java.util.List;

import com.logicq.logicq.model.common.DropdownData;

public interface ISearchDAO {
	
	public List<DropdownData> search(String searchfor);

}
