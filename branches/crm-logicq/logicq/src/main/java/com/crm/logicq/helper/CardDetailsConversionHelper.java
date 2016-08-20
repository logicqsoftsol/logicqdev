package com.crm.logicq.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.utils.DateUtils;
import com.crm.logicq.vo.attendance.CardDetailsVO;

public class CardDetailsConversionHelper {

	public static Map<String, CardDetailsVO> convertEntityToVO(List<CardReadDetails> carddetailslist) {
		Map<String, CardDetailsVO> cardetails=new HashMap<>();
		//carddetails.forEach((eachcard) -> {
		for(CardReadDetails  eachcard:carddetailslist){
			if (cardetails.containsKey(eachcard.getCardid())) {
				CardDetailsVO cardvo = cardetails.get(eachcard.getCardid());
				cardvo.setOuttime(DateUtils.getTimeFromDate(eachcard.getPunchdate()));
				cardetails.put(eachcard.getCardid(), cardvo);
			} else {
				CardDetailsVO cardvo = new CardDetailsVO();
				cardvo.setCardid(eachcard.getCardid());
				cardvo.setCardswapdate(eachcard.getPunchmonth());
				cardvo.setIntime(DateUtils.getTimeFromDate(eachcard.getPunchdate()));
				cardetails.put(eachcard.getCardid(), cardvo);
			}
		}
		//});
		
		return cardetails;

	}
	public static CardDetailsVO populateCard(CardReadDetails eachcard){
		
		return null;
	}
}
