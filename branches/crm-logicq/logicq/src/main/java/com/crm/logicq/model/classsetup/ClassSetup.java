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

    @Column(name = "NAME")
    @NotNull
    private String cal;
    
    @Column(name = "SECTION")
    private String section;
    
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="CLASS_SUBJECT", 
				joinColumns={@JoinColumn(name="CLASS_ID")}, 
				inverseJoinColumns={@JoinColumn(name="SUB_ID")})
     private List<Subject> subjectlist;
    
    
    @Column(name = "YEAR")
    private Integer applicableyear;

}
