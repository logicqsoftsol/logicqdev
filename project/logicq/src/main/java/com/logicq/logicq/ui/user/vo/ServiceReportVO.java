package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;
import java.util.List;

import com.logicq.logicq.model.user.servicereport.Recomendation;

public class ServiceReportVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1770627510650094114L;
	
    private String id;

	private List<RecomendationVO> recomendation;
	

	private List<FeedBackVO> feedback;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public List<RecomendationVO> getRecomendation() {
		return recomendation;
	}


	public void setRecomendation(List<RecomendationVO> recomendation) {
		this.recomendation = recomendation;
	}


	public List<FeedBackVO> getFeedback() {
		return feedback;
	}


	public void setFeedback(List<FeedBackVO> feedback) {
		this.feedback = feedback;
	}

	
	
}
