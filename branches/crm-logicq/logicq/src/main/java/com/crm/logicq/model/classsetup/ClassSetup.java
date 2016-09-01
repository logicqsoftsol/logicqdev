package com.crm.logicq.model.classsetup;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "CLASS_SETUP")
public class ClassSetup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3686727161871647739L;
	
	@Id
    @Column(name = "CLASS_ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classid;

    @Column(name = "CLASS_NAME")
    private String classname;
    
    @Column(name = "CLASS_TYPE")
    private String classtype;
    
    @Column(name = "SECTION_NAME")
    private String sectionname;
    
    @Column(name = "SECTION_TYPE")
    private String sectiontype;
    
    
    @Column(name = "TOTAL_STRENGTH")
    private String totalstrength;
    
    @Column(name = "CLASS_SHIFT")
    private String classshift;
    
    
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="CLASS_SUBJECT", 
				joinColumns={@JoinColumn(name="CLASS_ID")}, 
				inverseJoinColumns={@JoinColumn(name="SUB_ID")})
     private List<Subject> subjectlist;

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}


	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public String getSectiontype() {
		return sectiontype;
	}

	public void setSectiontype(String sectiontype) {
		this.sectiontype = sectiontype;
	}

	public List<Subject> getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(List<Subject> subjectlist) {
		this.subjectlist = subjectlist;
	}

	public String getTotalstrength() {
		return totalstrength;
	}

	public void setTotalstrength(String totalstrength) {
		this.totalstrength = totalstrength;
	}

	public String getClassshift() {
		return classshift;
	}

	public void setClassshift(String classshift) {
		this.classshift = classshift;
	}

	
	@Override
	public String toString() {
		return "ClassSetup [classid=" + classid + ", classname=" + classname + ", classtype=" + classtype
				+ ", sectionname=" + sectionname + ", sectiontype=" + sectiontype + ", totalstrength=" + totalstrength
				+ ", classshift=" + classshift + ", subjectlist=" + subjectlist + "]";
	}



}
