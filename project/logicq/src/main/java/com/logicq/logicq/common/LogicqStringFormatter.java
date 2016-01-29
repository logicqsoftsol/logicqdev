
package com.logicq.logicq.common;

import java.util.ArrayList;
import java.util.List;

import com.logicq.logicq.constant.LogicQConstants;

/**
 * 
 * @author NIHAR
 *
 */
public class LogicqStringFormatter {
	


	public static List<String> convertAutoCompleteFormat(List<String> inputlist) {

		List<String> formatedList = new ArrayList<String>();
		if (null != inputlist && !inputlist.isEmpty()) {
			for (String input : inputlist) {
				formatedList.add(LogicQConstants.BACK_SLASH + input.intern() + LogicQConstants.BACK_SLASH);
			}
		}
		return formatedList;
	}
}

