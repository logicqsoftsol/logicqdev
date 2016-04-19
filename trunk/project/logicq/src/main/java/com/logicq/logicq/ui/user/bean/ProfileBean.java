package com.logicq.logicq.ui.user.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.StreamedContent;
import org.springframework.util.StringUtils;

import com.logicq.logicq.ui.user.vo.FacilityVO;

@ManagedBean(name = "profileMB")
@ViewScoped
public class ProfileBean {

	private String fullname;
	private String spcification;
	private String exprience;
	private List<FacilityVO> facilityDetails;
	private String recomendation;
	private String feedback;
	private String location;
	private String fess;
	private StreamedContent profileimage;
	private String profileid;
	private String bookingdate = null;
	private EntityAvailabilityBean avilablityDetails;
	private String schduleformrender = "false";
	private String userImage;
    private String qualificationDetails;
    private boolean addressRendered;
    private boolean profileRendered;
    private boolean reportRendered;
    private boolean scheduleRendered;
    private boolean recenthistoryRendered;
    private boolean walletRendered;
    private boolean facilityRendered;
	private List<String> ratings;
   
	public boolean isFacilityRendered() {
		return facilityRendered;
	}

	public void setFacilityRendered(boolean facilityRendered) {
		this.facilityRendered = facilityRendered;
	}
	
	public boolean isProfileRendered() {
		return profileRendered;
	}

	public List<String> getRatings() {
		ratings=new ArrayList<String>();
		ratings.add("1");
		ratings.add("2");
		return ratings;
	}

	public void setRatings(List<String> ratings) {
		this.ratings = ratings;
	}

	public void setProfileRendered(boolean profileRendered) {
		this.profileRendered = profileRendered;
	}

	public boolean isReportRendered() {
		return reportRendered;
	}

	public void setReportRendered(boolean reportRendered) {
		this.reportRendered = reportRendered;
	}

	public boolean isScheduleRendered() {
		return scheduleRendered;
	}

	public void setScheduleRendered(boolean scheduleRendered) {
		this.scheduleRendered = scheduleRendered;
	}

	public boolean isRecenthistoryRendered() {
		return recenthistoryRendered;
	}

	public void setRecenthistoryRendered(boolean recenthistoryRendered) {
		this.recenthistoryRendered = recenthistoryRendered;
	}

	public boolean isWalletRendered() {
		return walletRendered;
	}

	public void setWalletRendered(boolean walletRendered) {
		this.walletRendered = walletRendered;
	}

	public boolean isAddressRendered() {
		return addressRendered;
	}

	public void setAddressRendered(boolean addressRendered) {
		this.addressRendered = addressRendered;
	}

	public String getUserImage() {

		return userImage;
	}

	public void setUserImage(String userImage) {

		this.userImage = userImage;
	}

	public String getQualificationDetails() {
		return qualificationDetails;
	}

	public void setQualificationDetails(String qualificationDetails) {
		this.qualificationDetails = qualificationDetails;
	}

	public String getSchduleformrender() {

		return schduleformrender;
	}

	public void setSchduleformrender(String schduleformrender) {

		this.schduleformrender = schduleformrender;
	}

	public String getBookingdate() {

		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {

		if (StringUtils.isEmpty(bookingdate)) {
			bookingdate = new Date().toString();
		}
		this.bookingdate = bookingdate;
	}

	public EntityAvailabilityBean getAvilablityDetails() {

		return avilablityDetails;
	}

	public void setAvilablityDetails(EntityAvailabilityBean avilablityDetails) {

		this.avilablityDetails = avilablityDetails;
	}

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

	public List<FacilityVO> getFacilityDetails() {

		return facilityDetails;
	}

	public void setFacilityDetails(List<FacilityVO> facilityDetails) {

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

		// FacesContext context = FacesContext.getCurrentInstance();
		//
		// if (context.getCurrentInstance().getResponseComplete()) {
		// // So, we're rendering the HTML. Return a stub StreamedContent so
		// that it will generate right URL.
		// return new DefaultStreamedContent();
		// }
		// else {
		// // So, browser is requesting the image. Return a real StreamedContent
		// with the image bytes.
		//// String studentId =
		// context.getExternalContext().getRequestParameterMap().get("studentId");
		//// Student student = studentService.find(Long.valueOf(studentId));
		// return new DefaultStreamedContent(new ByteArrayInputStream(null));
		// }
		return null;
	}
	
	private void defaultProfileRenderProperty() {
		setProfileRendered(false);
		setAddressRendered(false);
		setReportRendered(false);
		setScheduleRendered(false);
		setWalletRendered(false);
		setRecenthistoryRendered(false);
		setFacilityRendered(false);
	}
	
//	private boolean profileRendered;
 //   private boolean reportRendered;
  //  private boolean scheduleRendered;
  //  private boolean recenthistoryRendered;
  //  private boolean walletRendered;
    
	public void profileDetailsDisplay(ActionEvent action) {
		System.out.println("Test Profile");
		defaultProfileRenderProperty();
		setProfileRendered(true);
		
	}

	public void addressDetailsDisplay(ActionEvent action) {
		System.out.println("Test Address");
		defaultProfileRenderProperty();
		setAddressRendered(true);
	}

	public void reportDetailsDisplay(ActionEvent action) {
		System.out.println("Test report");
		defaultProfileRenderProperty();
		setReportRendered(true);
	}

	public void setupScheduleDetailsDisplay(ActionEvent action) {
		System.out.println("Test scudule");
		defaultProfileRenderProperty();
		setScheduleRendered(true);
	}

	public void walletDetailsDisplay(ActionEvent action) {
		System.out.println("Test wallet");
		defaultProfileRenderProperty();
		setWalletRendered(true);
	}

	public void historyDetailsDisplay(ActionEvent action) {
		System.out.println("Test history");
		defaultProfileRenderProperty();
		setRecenthistoryRendered(true);
	}
	
	public void facilityDetailsDisplay(ActionEvent action) {
		System.out.println("Test history");
		defaultProfileRenderProperty();
		setFacilityRendered(true);
	}
}
