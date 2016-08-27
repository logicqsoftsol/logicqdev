package com.crm.logicq.model.classsetup;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_SUBJECT")
public class ClassSubjectSetup {

	  @EmbeddedId
      private ClassSubjectKey classsubjmap;

	  @Column(name = "REFRENCE_BOOK")
	  private String refrebooks;

	public ClassSubjectKey getClasssubjmap() {
		return classsubjmap;
	}

	public void setClasssubjmap(ClassSubjectKey classsubjmap) {
		this.classsubjmap = classsubjmap;
	}

	public String getRefrebooks() {
		return refrebooks;
	}

	public void setRefrebooks(String refrebooks) {
		this.refrebooks = refrebooks;
	}

	@Override
	public String toString() {
		return "ClassSubjectSetup [classsubjmap=" + classsubjmap + ", refrebooks=" + refrebooks + "]";
	}
	  
	
	
}
