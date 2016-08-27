package com.crm.logicq.model.classsetup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "SUBJECT")
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -255001114921685629L;
	
	@Id
    @Column(name = "SUB_ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectid;

    @Column(name = "NAME")
    @NotNull
    private String name;
    
    @Column(name = "SHORT_NAME")
    private String shortname;
    
    @Column(name = "type")
    private String type;

	public Long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", name=" + name + ", shortname=" + shortname + ", type=" + type
				+ "]";
	}
    
    
    

}
