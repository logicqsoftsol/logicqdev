package com.crm.logicq.model.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.crm.logicq.model.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CONTACT_DETAILS")
public class ContactDetails extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4069700092964331504L;

	@Id
	@Column(name = "CONTACT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy="contactdetails",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private AddressDetails addressdetails;
	
	
	@OneToOne(mappedBy="contactdetails",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private CommunicationDetails communicationdetails;


	@JsonIgnore
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="EMP_ID")
	private Employee employee;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public AddressDetails getAddressdetails() {
		return addressdetails;
	}


	public void setAddressdetails(AddressDetails addressdetails) {
		this.addressdetails = addressdetails;
	}


	public CommunicationDetails getCommunicationdetails() {
		return communicationdetails;
	}


	public void setCommunicationdetails(CommunicationDetails communicationdetails) {
		this.communicationdetails = communicationdetails;
	}




	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "ContactDetails [id=" + id + ", addressdetails=" + addressdetails + ", communicationdetails="
				+ communicationdetails +"]";
	}


	
	
	
}
