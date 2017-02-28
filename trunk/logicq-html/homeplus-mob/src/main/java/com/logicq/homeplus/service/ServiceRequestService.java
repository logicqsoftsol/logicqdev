package com.logicq.homeplus.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.homeplus.common.SMSHelper;
import com.logicq.homeplus.common.ServiceEnum;
import com.logicq.homeplus.dao.IDocumentUploadDAO;
import com.logicq.homeplus.dao.IServiceRequestDAO;
import com.logicq.homeplus.dao.otp.IOTPDao;
import com.logicq.homeplus.helper.DateHelper;
import com.logicq.homeplus.helper.SMSMessageHelper;
import com.logicq.homeplus.model.OTPDetails;
import com.logicq.homeplus.model.SMSDetails;
import com.logicq.homeplus.model.ServiceDetailVO;
import com.logicq.homeplus.model.ServiceDetails;
import com.logicq.homeplus.model.ServiceList;
import com.logicq.homeplus.model.UploadDocument;

@Service
@Transactional
public class ServiceRequestService implements IServiceRequestService {

	@Autowired
	IServiceRequestDAO serviceDetailsDAO;
	
	@Autowired
	IOTPDao otpDAO;
	
	@Autowired
	IDocumentUploadDAO documentUploadDao;
	


	@Override
	public void saveServiceDetails(ServiceDetails serviceDetails) {
		   serviceDetails.setRefrenceNumber(SMSMessageHelper.nextRefrenceNumber());
		    serviceDetails.setServiceStatus(ServiceEnum.ORDERED.name());
		    serviceDetails.setServiceRequestDate(new Date());
	    	serviceDetailsDAO.saveServiceDetails(serviceDetails);
	}



	@Override
	public void saveOrUpdateOTPDetails(OTPDetails otpdetails) {
		if(null==otpdetails.getKey().getOtpnumber()){
		otpdetails.getKey().setOtpnumber(SMSMessageHelper.generateOTP());
		}
		otpDAO.saveOrUpdateOTPDetails(otpdetails);
		if (null != otpdetails  && !otpdetails.isOtpvalidate()) {
			SMSDetails smsDetailsforUser = new SMSDetails();
			smsDetailsforUser.setMobilenumber(otpdetails.getKey().getMobilenumber());
			smsDetailsforUser
					.setMessage(SMSMessageHelper.generateMessageForOTPRequest(String.valueOf(otpdetails.getKey().getOtpnumber())));
			SMSHelper.sendSMS(smsDetailsforUser);
		}
		
	}



	@Override
	public OTPDetails validateOTPForMobileNumber(int otp, String mobilenumber) {
		return otpDAO.validateOTPForMobileNumber(otp, mobilenumber);
	}



	@Override
	public void sendSMSForServiceRequest(String mobileNumber, String serviceRefrenceNumber) {
		ServiceDetails serviceDetails = serviceDetailsDAO.getServiceDetailsAccordingToRefrence(serviceRefrenceNumber);
		if (null != serviceDetails) {
			SMSDetails smsDetailsforUser = new SMSDetails();
			smsDetailsforUser.setMobilenumber(mobileNumber);
			smsDetailsforUser
					.setMessage(SMSMessageHelper.generateMessageForServiceRequest(serviceDetails.getServicename()));
			SMSHelper.sendSMS(smsDetailsforUser);
		}

	}



	@Override
	public void saveDocumentDetails(UploadDocument uploadDocument) {
		documentUploadDao.saveDocumentDetails(uploadDocument);
	}



	@Override
	public List<UploadDocument> getDocumentsAccordingToDate(Date inputDate, long userid) {
		return documentUploadDao.getDocumentsAccordingToDate(inputDate, userid);
	}



	@Override
	public UploadDocument getDocuemnt(long docuemntid) {
		return documentUploadDao.getDocuemnt(docuemntid);
	}



	@Override
	public void getServiceDetailsAccordingToFilter(ServiceList serviceList) {
		Date startDate = DateHelper.getDateAccordingToInterval(serviceList.getDayInterval());
		serviceList.setFromdate(startDate);
		serviceList.setTodate(new Date());
		List<ServiceDetails> servicDetails = serviceDetailsDAO.getServiceDetailsAccordingToFilter(serviceList);
		List<ServiceDetailVO> serviceDetailList = new ArrayList<>();
		if (null != servicDetails && !servicDetails.isEmpty()) {
			serviceList.setServiceCount(servicDetails.size());
			for (ServiceDetails service : servicDetails) {
				ServiceDetailVO serviceDetailVO = new ServiceDetailVO();
				serviceDetailVO.setCustomermob(service.getCustomermob());
				serviceDetailVO.setCustomername(service.getCustomername());
				if (service.getDocumentId() == 0) {
					serviceDetailVO.setServiceDetails(service.getRequestDetails());
				} else {
					UploadDocument orderImage = documentUploadDao.getDocuemnt(service.getDocumentId());
					serviceDetailVO.setImageURL(orderImage.getDocumentPath());
				}
				serviceDetailVO.setLocation(service.getCustomeraddress());
				serviceDetailVO.setRefrenceNumber(service.getRefrenceNumber());
				serviceDetailVO.setRequestDate(service.getServiceRequestDate());
				serviceDetailVO.setServiceDate(service.getServicedate());
				serviceDetailVO.setServicetime(service.getServicetime());
				serviceDetailVO.setStatus(service.getServiceStatus());
				serviceDetailList.add(serviceDetailVO);
			}
		}
		serviceList.setServiceList(serviceDetailList);
	}

}
