package com.crm.logicq.model.education;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.crm.logicq.model.user.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EDUCATION_DETAILS")
public class EducationDetails {

	@Id
	@Column(name = "EDUCATION_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "CLASS_NAME", nullable = true)
	private String classname;
	
	@Column(name = "SECTION_NAME", nullable = true)
	private String sectionname;
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getClassname() {
		return classname;
	}


	public void setClassname(String classname) {
		this.classname = classname;
	}


	public String getSectionname() {
		return sectionname;
	}


	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "EducationDetails [id=" + id + ", classname=" + classname + ", sectionname=" + sectionname + ", student="
				+ student + "]";
	}
	
	
	

}
