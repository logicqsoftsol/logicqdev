package com.crm.logicq.model.classsetup;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_SUBJECT")
public class ClassSubjectMapping {

	  @EmbeddedId
      private ClassSubjectKey classsubjmap;

	public ClassSubjectKey getClasssubjmap() {
		return classsubjmap;
	}

	public void setClasssubjmap(ClassSubjectKey classsubjmap) {
		this.classsubjmap = classsubjmap;
	}
	

	@Override
	public String toString() {
		return "ClassSubjectMapping [classsubjmap=" + classsubjmap + "]";
	}
	  
	  
	
}
