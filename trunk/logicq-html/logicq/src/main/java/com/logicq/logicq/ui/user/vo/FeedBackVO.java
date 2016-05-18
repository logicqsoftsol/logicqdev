package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;
import java.util.Date;

public class FeedBackVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4925986095871362275L;
	
	private String feedbackmessage;
	
	private String feedbackusername;
	
	private Date feedbackdate;

	public String getFeedbackmessage() {
		return feedbackmessage;
	}

	public void setFeedbackmessage(String feedbackmessage) {
		this.feedbackmessage = feedbackmessage;
	}

	public String getFeedbackusername() {
		return feedbackusername;
	}

	public void setFeedbackusername(String feedbackusername) {
		this.feedbackusername = feedbackusername;
	}

	public Date getFeedbackdate() {
		return feedbackdate;
	}

	public void setFeedbackdate(Date feedbackdate) {
		this.feedbackdate = feedbackdate;
	}
	

}
