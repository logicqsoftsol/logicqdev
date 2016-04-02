package com.logicq.logicq.ui.user.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.StreamedContent;

@ManagedBean(name = "profileMB")
@RequestScoped
public class ProfileBean {
	
	private String fullname;
	private String spcification;
	private String exprience;
	private String facilityDetails;
	private String recomendation;
	private String feedback;
	private String location;
	private String fess;
	private StreamedContent profileimage;
	private String profileid;
    

	public String getProfileid() {
		return profileid;
	}


	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}

	public StreamedContent getProfileimage() {
		return profileimage;
	}


	public void setProfileimage(StreamedContent profileimage) {
		this.profileimage = profileimage;
	}


	public String getFullname() {
	
		return fullname;
	}
	

	public void setFullname(String fullname) {
	
		this.fullname = fullname;
	}
	
	public String getSpcification() {
	
		return spcification;
	}
	
	public void setSpcification(String spcification) {
	
		this.spcification = spcification;
	}
	
	public String getExprience() {
	
		return exprience;
	}
	
	public void setExprience(String exprience) {
	
		this.exprience = exprience;
	}
	
	public String getFacilityDetails() {
	
		return facilityDetails;
	}
	
	public void setFacilityDetails(String facilityDetails) {
	
		this.facilityDetails = facilityDetails;
	}
	
	public String getRecomendation() {
	
		return recomendation;
	}
	
	public void setRecomendation(String recomendation) {
	
		this.recomendation = recomendation;
	}
	
	public String getFeedback() {
	
		return feedback;
	}
	
	public void setFeedback(String feedback) {
	
		this.feedback = feedback;
	}
	
	public String getLocation() {
	
		return location;
	}
	
	public void setLocation(String location) {
	
		this.location = location;
	}
	
	public String getFess() {
	
		return fess;
	}
	
	public void setFess(String fess) {
	
		this.fess = fess;
	}
	
	 public StreamedContent getImage() throws IOException {
//	        FacesContext context = FacesContext.getCurrentInstance();
//
//	        if (context.getCurrentInstance().getResponseComplete()) {
//	            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
//	            return new DefaultStreamedContent();
//	        }
//	        else {
//	            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
////	            String studentId = context.getExternalContext().getRequestParameterMap().get("studentId");
////	            Student student = studentService.find(Long.valueOf(studentId));
//	            return new DefaultStreamedContent(new ByteArrayInputStream(null));
//	        }
		 return null;
	    }

}
