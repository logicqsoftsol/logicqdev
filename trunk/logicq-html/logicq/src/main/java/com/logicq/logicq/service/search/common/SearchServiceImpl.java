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
import com.logicq.logicq.model.user.facility.Facility;
import com.logicq.logicq.ui.user.vo.FacilityVO;

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
			List<FacilityVO> facilities=new ArrayList<FacilityVO>();
			SPBasic spbasic = new SPBasic();
			spbasic.setFullname("firstname"+i+ " " + "firstname"+i);
			spbasic.setQualification("MBBS , MD - Medicine , DNB (Cardiology)");
			for(Facility faci:serviceproviderlist.get(0).getFacilities()){
				FacilityVO faclityvo=new FacilityVO();
				faclityvo.setFacilityImagePath(faci.getFacilityImagePath());
				faclityvo.setFacilityName(faci.getFacilityName());
				facilities.add(faclityvo);
			}
			spbasic.setFacilites(facilities);
			spbasic.setAvilablelocation("pune");
			spbasic.setProfileimage("assets/admin1/img/male-doctor.jpg");
			spbasic.setFeedback("100"+i);
			spbasic.setExprience("12 years");
			spbasic.setAvilablelocation("Pune");
			spbasic.setFees("500"+i);
			spbasic.setRecommendations("100"+i+10);
			spbasiclist.add(spbasic);
		}
		return spbasiclist;
	}

	@Override
	public List<DropdownData> searchSpecialisation(String searchfor) {
		return searchdao.searchSpecialisation(searchfor);
	}

	
	
}
