package com.logicq.logicq.model.user.servicereport;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.model.user.User;


@Entity
@Table(name = "SERVICEREPORT")
public class ServiceReport extends BaseEntity implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1664877756445206884L;

	@Id
	@Column(name = "REPORT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = true)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceReport")
	private Set<Recomendation> recomendation;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceReport")
	private Set<FeedBack> feedback;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Recomendation> getRecomendation() {
		return recomendation;
	}

	public void setRecomendation(Set<Recomendation> recomendation) {
		this.recomendation = recomendation;
	}

	
}
