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
    
    @ManyToMany(mappedBy="subjectlist",fetch=FetchType.LAZY)
	private List<ClassSetup> classdetails = new ArrayList<ClassSetup>();
    
    @Column(name = "type")
    private String type;

}
