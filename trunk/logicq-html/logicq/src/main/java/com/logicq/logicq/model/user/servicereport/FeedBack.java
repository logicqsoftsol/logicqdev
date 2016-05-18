package com.logicq.logicq.model.user.servicereport;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.model.user.User;

@Entity
@Table(name = "FEEDBACK")
public class FeedBack extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7331258099819134857L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackid;
	
	
	@ManyToOne
	@JoinColumn(name = "SERVICE_REPORT_ID", nullable = true)
	private ServiceReport serviceReport;
	
	@OneToOne
	@JoinColumn(name = "USER_ID", nullable = true)
	private User serviceconsumer;
	
	
	public Long getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(Long feedbackid) {
		this.feedbackid = feedbackid;
	}



	public User getServiceconsumer() {
		return serviceconsumer;
	}

	public void setServiceconsumer(User serviceconsumer) {
		this.serviceconsumer = serviceconsumer;
	}

	
	
}
