package com.logicq.logicq.service.search.common;

import java.util.List;

import com.logicq.logicq.model.common.DropdownData;

public interface ISearchService {
	
	public List<DropdownData> search(String searchfor);

}
