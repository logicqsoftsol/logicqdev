package com.logicq.logicq.model.serviceprovider;

import java.util.List;
import java.util.Set;

import com.logicq.logicq.model.user.facility.Facility;

public class SPBasic {
	
	private String fullname;
	private String qualification;
	private String exprience;
	private String recommendations;
	private String feedback;
	private String avilablelocation;
	private String fees;
	private Set<Facility> facilites;
	private String profileimage;
	private String speciality;
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getExprience() {
		return exprience;
	}
	public void setExprience(String exprience) {
		this.exprience = exprience;
	}
	public String getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getAvilablelocation() {
		return avilablelocation;
	}
	public void setAvilablelocation(String avilablelocation) {
		this.avilablelocation = avilablelocation;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public Set<Facility> getFacilites() {
		return facilites;
	}
	public void setFacilites(Set<Facility> facilites) {
		this.facilites = facilites;
	}
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	@Override
	public String toString() {
		return "SPBasic [fullname=" + fullname + ", qualification=" + qualification + ", exprience=" + exprience
				+ ", recommendations=" + recommendations + ", feedback=" + feedback + ", avilablelocation="
				+ avilablelocation + ", fees=" + fees + ", facilites=" + facilites + ", profileimage=" + profileimage
				+ "]";
	}
	
	
	

}
