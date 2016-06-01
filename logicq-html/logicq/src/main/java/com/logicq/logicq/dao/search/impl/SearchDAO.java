package com.logicq.logicq.dao.search.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.search.ISearchDAO;
import com.logicq.logicq.model.common.DropdownData;

@Repository
public class SearchDAO extends AbstractDAO<DropdownData> implements ISearchDAO{

	@Override
	public List<DropdownData> search(String searchfor) {
		List<DropdownData> dropdownlist=new ArrayList<DropdownData>();
		if ("location".equalsIgnoreCase(searchfor)) {
			String query = "select distinct addr.city as value ,addr.city as name from Address addr";
			 List<Object[]> locationlist= (List<Object[]>) execcuteQuery(query);
			 populateDropDown(locationlist,dropdownlist);
		}
		if ("entity".equalsIgnoreCase(searchfor)) {
			String query = "select  ent.entityId as name ,ent.entityName as value from EntityRole ent";
			 List<Object[]> entitylist=(List<Object[]>) execcuteQuery(query);
			 populateDropDown(entitylist,dropdownlist);
		}
		return dropdownlist;
	}

	public void populateDropDown(List<Object[]> objectlist, List<DropdownData> dropdownlist) {
		for (Object[] object : objectlist) {
			DropdownData dropdown = new DropdownData();
			dropdown.setValue(String.valueOf(object[1]));
			dropdown.setName(String.valueOf(object[0]));
			dropdownlist.add(dropdown);
		}

	}
}
