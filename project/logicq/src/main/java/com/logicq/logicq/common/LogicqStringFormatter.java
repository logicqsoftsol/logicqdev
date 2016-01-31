
package com.logicq.logicq.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.logicq.logicq.constant.LogicQConstants;
import com.logicq.logicq.model.entity.EntityRole;
import com.logicq.logicq.model.location.Location;

/**
 * 
 * @author NIHAR
 *
 */
public class LogicqStringFormatter {
	


	private static final String STRING_COMMA = ",";

	public static List<String> convertAutoCompleteFormat(List<Location> inputlist) {

		List<String> formatedList = new ArrayList<String>();
		if (null != inputlist && !inputlist.isEmpty()) {
			for (Location input : inputlist) {
				
				String searchresult=LogicQConstants.BACK_SLASH + input.getLocality()+STRING_COMMA+input.getLocationName()+STRING_COMMA+input.getPincode() + LogicQConstants.BACK_SLASH;
				if(StringUtils.isEmpty(input.getLocality())||null==input.getPincode()){
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
}

