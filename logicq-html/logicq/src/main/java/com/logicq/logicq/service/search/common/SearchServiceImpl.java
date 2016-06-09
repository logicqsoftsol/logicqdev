package com.logicq.logicq.service.search.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.dao.search.ISearchDAO;
import com.logicq.logicq.model.common.DropdownData;
import com.logicq.logicq.model.serviceprovider.SPBasic;
import com.logicq.logicq.model.user.User;

@Service
@Transactional
public class SearchServiceImpl implements ISearchService {
    
	@Autowired
	ISearchDAO searchdao;
	
	@Override
	public List<DropdownData> search(String searchfor) {
		return searchdao.search(searchfor);
	}

	@Override
	public List<SPBasic> searchServiceProvider(String location, String entitype) {
		List<SPBasic> spbasiclist = new ArrayList<SPBasic>();
		List<User> serviceproviderlist = searchdao.searchServiceProvider(location, entitype);
		
		for (int i=0; i<10;i++) {
			SPBasic spbasic = new SPBasic();
			spbasic.setFullname("firstname"+i+ " " + "firstname"+i);
			spbasic.setQualification("MBBS , MD - Medicine , DNB (Cardiology)");
			//spbasic.setFacilites(sp.getFacilities());
			spbasic.setAvilablelocation("pune");
			spbasic.setProfileimage("assets/admin1/img/male-doctor.jpg");
			spbasic.setFeedback("100");
			spbasic.setExprience("12 years");
			spbasic.setAvilablelocation("Pune");
			spbasic.setFees("500");
			spbasic.setRecommendations("100");
			spbasiclist.add(spbasic);
		}
		return spbasiclist;
	}

	
	
}
