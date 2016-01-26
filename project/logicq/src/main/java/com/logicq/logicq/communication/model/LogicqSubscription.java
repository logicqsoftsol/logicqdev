package com.logicq.logicq.communication.model;

import java.util.Date;

import com.logicq.logicq.model.user.User;

public class LogicqSubscription {

	private User user;
	private String serviceid;

	private String subscriptionid;

	private String subscriptiondetails;

	private boolean issubscriptionactive;

	private Date expirydate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getServiceid() {
		return serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

	public String getSubscriptionid() {
		return subscriptionid;
	}

	public void setSubscriptionid(String subscriptionid) {
		this.subscriptionid = subscriptionid;
	}

	public String getSubscriptiondetails() {
		return subscriptiondetails;
	}

	public void setSubscriptiondetails(String subscriptiondetails) {
		this.subscriptiondetails = subscriptiondetails;
	}

	public boolean isIssubscriptionactive() {
		return issubscriptionactive;
	}

	public void setIssubscriptionactive(boolean issubscriptionactive) {
		this.issubscriptionactive = issubscriptionactive;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

}
