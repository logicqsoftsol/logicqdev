package com.logicq.homeplus.service;

import java.util.Date;
import java.util.List;

import com.logicq.homeplus.model.OTPDetails;
import com.logicq.homeplus.model.ServiceDetails;
import com.logicq.homeplus.model.ServiceList;
import com.logicq.homeplus.model.UploadDocument;

public interface IServiceRequestService {
	
    void saveServiceDetails(ServiceDetails serviceDetails);
    void saveOrUpdateOTPDetails(OTPDetails otpdetails);
    OTPDetails validateOTPForMobileNumber(int otp,String mobilenumber);
    void sendSMSForServiceRequest(String mobileNumber, String serviceRefrenceNumber);
    void saveDocumentDetails(UploadDocument uploadDocument);
	List<UploadDocument> getDocumentsAccordingToDate(Date inputDate,long userid);
	UploadDocument getDocuemnt(long docuemntid);
	 void getServiceDetailsAccordingToFilter(ServiceList serviceList);

}
