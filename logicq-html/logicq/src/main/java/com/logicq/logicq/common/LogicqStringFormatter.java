
package com.logicq.logicq.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.logicq.logicq.constant.LogicQConstants;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.user.User;

/**
 * 
 * @author NIHAR
 *
 */
public class LogicqStringFormatter {
	


	private static final String STRING_COMMA = ",";

	public static List<String> convertAutoCompleteFormat(List<Address> inputlist) {

		List<String> formatedList = new ArrayList<String>();
		if (null != inputlist && !inputlist.isEmpty()) {
			for (Address input : inputlist) {
				
				String searchresult=LogicQConstants.BACK_SLASH + input.getLocalityname()+STRING_COMMA+input.getCity()+STRING_COMMA+input.getPincode()+LogicQConstants.BACK_SLASH;
				if(StringUtils.isEmpty(input.getLocalityname())||null==input.getPincode()){
				searchresult=searchresult.replaceAll("null,","" ).replace(",null", "");
				}
				formatedList.add(searchresult);
			}
		}
		return formatedList;
	}
	public static List<String> convertAutoCompleteFormatEntity(List<EntityRole> inputlist) {

		List<String> formatedList = new ArrayList<String>();
		if (null != inputlist && !inputlist.isEmpty()) {
			for (EntityRole input : inputlist) {
				
				String searchresult=LogicQConstants.BACK_SLASH + input.getEntityName() + LogicQConstants.BACK_SLASH;
				 
				formatedList.add(searchresult);
			}
		}
		return formatedList;
	}
	
	public static List<String> convertAutoCompleteFormatLat(List<User> inputlist) {

		List<String> formatedList = new ArrayList<String>();
		if (null != inputlist && !inputlist.isEmpty()) {
			for (User user : inputlist) {
				
				
				for (Address address : user.getAddresses()) {
					
					String searchresult= LogicQConstants.BACK_SLASH +user.getEntityType()+STRING_COMMA+user.getFirstName()+STRING_COMMA+address.getLocalityname()+STRING_COMMA+address.getCity()+STRING_COMMA+
						address.getPincode()+STRING_COMMA+address.getLatitude()+STRING_COMMA+address.getLongitude()+LogicQConstants.BACK_SLASH;
					 formatedList.add(searchresult);
					 }
				
				 
				// String searchresult=LogicQConstants.BACK_SLASH + input.getLocalityname()+STRING_COMMA+input.getCity()+STRING_COMMA+input.getPincode()+STRING_COMMA+input.getLatitude()+STRING_COMMA+input.getLongitude()+ LogicQConstants.BACK_SLASH;
				
			}
		}
		return formatedList;
	}
}

