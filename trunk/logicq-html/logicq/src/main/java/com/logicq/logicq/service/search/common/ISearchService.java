package com.logicq.logicq.service.search.common;

import java.util.List;

import com.logicq.logicq.model.common.DropdownData;
import com.logicq.logicq.model.serviceprovider.SPBasic;

public interface ISearchService {
	
	public List<DropdownData> search(String searchfor);
	public List<DropdownData> searchSpecialisation(String searchfor);
	
	public List<SPBasic> searchServiceProvider(String location,String entitype);

}
