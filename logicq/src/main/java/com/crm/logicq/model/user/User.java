package com.crm.logicq.model.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.crm.logicq.constant.EntityType;
import com.crm.logicq.model.common.BaseEntity;
import com.crm.logicq.model.communication.PhoneCommunication;

/**
 * 
 * @author SudhanshuLenka
 *
 */
@Entity
@Table(name = "USER")
public class User  extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6849647946985720632L;


	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IDENTIFICATION_ID", nullable = false)
	private String idetificationid;
	
	@Column(name = "USER_ID", nullable = false)
	private String userid;
	
	@Column(name = "FIRST_NAME", nullable = true)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = true)
	private String lastName;
	

	
	@Column(name = "EMAIL_ID", unique = true, nullable = true)
	private String email;
	
	@Column(name = "GENDER", nullable = true)
	private String gender;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private PhoneCommunication communication;
	
	@Column(name = "ENTITY_TYPE", nullable = true)
	@Enumerated(EnumType.STRING)
	private EntityType entityType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdetificationid() {
		return idetificationid;
	}

	public void setIdetificationid(String idetificationid) {
		this.idetificationid = idetificationid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public PhoneCommunication getCommunication() {
		return communication;
	}

	public void setCommunication(PhoneCommunication communication) {
		this.communication = communication;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", idetificationid=" + idetificationid + ", userid=" + userid + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", communication=" + communication + ", entityType=" + entityType + "]";
	}


	
}
