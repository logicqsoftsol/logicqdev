package com.logicq.logicq.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;

/**
 * NIHAR 01-Feb-2016 1:08:12 am
 */
@Entity
@Table(name = "ENTITY")
public class EntityRole {

	@Id
	@Column(name = "ENTITYID", unique = true, nullable = false)
	private Long entityId;
	@Column(name = "ENTITYNAME", nullable = false)
	private String entityName;

	public Long getEntityId() {

		return entityId;
	}

	public void setEntityId(Long entityId) {

		this.entityId = entityId;
	}

	public String getEntityName() {

		return entityName;
	}

	public void setEntityName(String entityName) {

		this.entityName = entityName;
	}
}
