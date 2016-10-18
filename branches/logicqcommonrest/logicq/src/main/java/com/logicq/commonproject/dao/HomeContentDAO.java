package com.logicq.commonproject.dao;

import java.util.List;

import org.hibernate.Query;
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
	public List<HomeContent> getHomeWebContent(String imageType) {
		StringBuilder  selectquery=new StringBuilder(" from HomeContent home where ");
		if(!imageType.equals("ALL") && !(imageType.equals("HOMESLIDER"))){
		  //selectquery= new StringBuilder(" from HomeContent home where home.name ="+"'"+imageType+"'");
			selectquery.append("home.name ="+"'"+imageType+"'");
		}
		else if (imageType.equals("HOMESLIDER")) {
			selectquery.append("home.name like ('%Slider%')");
		}
		else {
			selectquery.append("home.name IN ('CLASSROOM','LIBRARY','SPORTS','ANNUALFUNCTION')");
		}
		Query query = getCurrentSession().createQuery(selectquery.toString());
		return (List<HomeContent>) query.list();
	}

}
