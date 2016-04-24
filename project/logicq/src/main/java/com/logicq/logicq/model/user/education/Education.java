package com.logicq.logicq.model.user.education;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.model.user.Profile;

@Entity
@Table(name = "EDUCATION")
public class Education extends BaseEntity  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6871451089963944163L;
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Profile profile;
	
	@Column(name = "EDU_HIGH", nullable = false)
	private String higestQualicfication;
	
	@Column(name = "EDU_SPCILAZTION", nullable = false)
	private String specialization;
	
	public String getHigestQualicfication() {
		return higestQualicfication;
	}
	public void setHigestQualicfication(String higestQualicfication) {
		this.higestQualicfication = higestQualicfication;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
