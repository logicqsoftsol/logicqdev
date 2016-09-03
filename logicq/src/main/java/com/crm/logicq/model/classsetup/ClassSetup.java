package com.crm.logicq.model.classsetup;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CLASS_SETUP")
public class ClassSetup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3686727161871647739L;
	
	@EmbeddedId
     private ClassSectionKey key;
	 
	 
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
    
    
   	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="CLASS_SUBJECT", 
				joinColumns={@JoinColumn(name="CLASS_ID"),@JoinColumn(name="SECTION_ID")}, 
				inverseJoinColumns={@JoinColumn(name="SUB_ID")})
     private Set<Subject> subjectlist;
    
   	
    private String compsubjectlist;
    
    private String optionalsubjectlist;

	public Set<Subject> getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(Set<Subject> subjectlist) {
		this.subjectlist = subjectlist;
	}


   	public ClassSectionKey getKey() {
   		return key;
   	}

   	public void setKey(ClassSectionKey key) {
   		this.key = key;
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
	
	

	public String getCompsubjectlist() {
		return compsubjectlist;
	}

	public void setCompsubjectlist(String compsubjectlist) {
		this.compsubjectlist = compsubjectlist;
	}

	public String getOptionalsubjectlist() {
		return optionalsubjectlist;
	}

	public void setOptionalsubjectlist(String optionalsubjectlist) {
		this.optionalsubjectlist = optionalsubjectlist;
	}

	@Override
	public String toString() {
		return "ClassSetup [key=" + key + ", classname=" + classname + ", classtype=" + classtype + ", sectionname="
				+ sectionname + ", sectiontype=" + sectiontype + ", totalstrength=" + totalstrength + ", classshift="
				+ classshift + ", subjectlist=" + subjectlist + "]";
	}

	
}
