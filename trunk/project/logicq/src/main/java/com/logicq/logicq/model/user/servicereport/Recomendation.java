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
@Table(name = "RECOMENDATION")
public class Recomendation extends  BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6236637444216021368L;
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recomendationid;
	
	@OneToOne
	@JoinColumn(name = "SERVICE_CONSUMER_ID", nullable = true)
	private User serviceconsumer;
	
	@ManyToOne
	@JoinColumn(name = "SERVICE_REPORT_ID", nullable = true)
	private ServiceReport serviceReport;

	public Long getRecomendationid() {
		return recomendationid;
	}

	public void setRecomendationid(Long recomendationid) {
		this.recomendationid = recomendationid;
	}

	public User getServiceconsumer() {
		return serviceconsumer;
	}

	public void setServiceconsumer(User serviceconsumer) {
		this.serviceconsumer = serviceconsumer;
	}

	public ServiceReport getMarketstatus() {
		return serviceReport;
	}

	public void setMarketstatus(ServiceReport marketstatus) {
		this.serviceReport = marketstatus;
	}
	
	
}
