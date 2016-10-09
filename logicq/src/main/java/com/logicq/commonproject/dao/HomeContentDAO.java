package com.logicq.commonproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.commonproject.model.HomeContent;

@Repository
public class HomeContentDAO extends AbstractDAO<HomeContent> implements IHomeContentModificationDAO{

	

	@Override
	public void saveorUpdateHomeWebContent(HomeContent homecontent) {
		 saveOrUpdate(homecontent);
	}

	@Override
	public List<HomeContent> getHomeWebContent() {
		return (List<HomeContent>) loadClass(HomeContent.class);
	}

}
