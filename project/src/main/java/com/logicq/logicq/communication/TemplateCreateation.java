package com.logicq.logicq.communication;

import org.springframework.util.StringUtils;

import com.logicq.logicq.communication.model.LogicqSubscription;
import com.logicq.logicq.model.user.User;

public class TemplateCreateation {
	
	
	
public void validateSubscription(LogicqSubscription logicqsubscription){
	User l_user=logicqsubscription.getUser();
	String l_serviceid=logicqsubscription.getServiceid();
	fetchSubscriptionDteails(l_user,l_serviceid);
}

private void fetchSubscriptionDteails(User l_user, String l_serviceid) {
	if(!StringUtils.isEmpty(l_serviceid)){
		
		
	}
	
}	
	

}
