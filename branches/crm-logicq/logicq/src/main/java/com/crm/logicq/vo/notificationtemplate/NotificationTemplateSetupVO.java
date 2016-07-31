package com.crm.logicq.vo.notificationtemplate;

import java.io.Serializable;
import java.util.List;

import com.crm.logicq.model.alert.NotificationSetupDetails;

public class NotificationTemplateSetupVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4427768190963553059L;
	
	private List<NotificationSetupDetails>  notisendingdetails;
	private NotificationTemplateSetupCriteria notisendingdetailscriteria;
	
	public List<NotificationSetupDetails> getNotisendingdetails() {
		return notisendingdetails;
	}
	public void setNotisendingdetails(List<NotificationSetupDetails> notisendingdetails) {
		this.notisendingdetails = notisendingdetails;
	}
	public NotificationTemplateSetupCriteria getNotisendingdetailscriteria() {
		return notisendingdetailscriteria;
	}
	public void setNotisendingdetailscriteria(NotificationTemplateSetupCriteria notisendingdetailscriteria) {
		this.notisendingdetailscriteria = notisendingdetailscriteria;
	}
	
	@Override
	public String toString() {
		return "NotificationTemplateSetupVO [notisendingdetails=" + notisendingdetails + ", notisendingdetailscriteria="
				+ notisendingdetailscriteria + "]";
	}

}
