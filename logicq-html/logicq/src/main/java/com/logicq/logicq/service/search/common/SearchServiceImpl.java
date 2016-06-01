package com.logicq.logicq.service.search.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.dao.search.ISearchDAO;
import com.logicq.logicq.model.common.DropdownData;

@Service
@Transactional
public class SearchServiceImpl implements ISearchService {
    
	@Autowired
	ISearchDAO searchdao;
	
	@Override
	public List<DropdownData> search(String searchfor) {
		return searchdao.search(searchfor);
	}

}
