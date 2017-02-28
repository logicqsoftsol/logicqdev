package com.logicq.homeplus.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.swing.DocumentTreeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.logicq.homeplus.OtpVO;
import com.logicq.homeplus.model.OTPDetails;
import com.logicq.homeplus.model.OTPKey;
import com.logicq.homeplus.model.ServiceDetails;
import com.logicq.homeplus.model.ServiceList;
import com.logicq.homeplus.model.UploadDocument;
import com.logicq.homeplus.service.IServiceRequestService;

@RestController
@RequestMapping("/service")
@MultipartConfig(fileSizeThreshold = 20971520)
public class ServiceController {
	
	
	@Autowired
	IServiceRequestService servicerequestdetails;
	
	@RequestMapping(value = "/requestService", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OtpVO> userRegister(@RequestBody ServiceDetails servicedetails) throws Exception {
		OtpVO otpvo=new OtpVO();
		OTPDetails otpDetails=new OTPDetails();
		if(!StringUtils.isEmpty(servicedetails.getCustomermob())){
				otpDetails.setOtpvalidate(Boolean.FALSE);
				otpDetails.setKey(new OTPKey());
				otpDetails.getKey().setCreationdate(new Date());
				otpDetails.getKey().setMobilenumber(servicedetails.getCustomermob());
				servicerequestdetails.saveOrUpdateOTPDetails(otpDetails);
				servicerequestdetails.saveServiceDetails(servicedetails);
				otpvo.setMobileNumber(otpDetails.getKey().getMobilenumber());
				otpvo.setRefrenceNumber(servicedetails.getRefrenceNumber());
			}
		return new ResponseEntity<OtpVO>(otpvo, HttpStatus.OK);
	}
	
	
	

	
	
	@RequestMapping(value = "/validateotp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OtpVO> otpVerification(@RequestBody OtpVO otpvo) throws Exception {
		if(!StringUtils.isEmpty(otpvo.getMobileNumber()) && otpvo.getOtpCode()!=0){
			OTPDetails otpDetails=servicerequestdetails.validateOTPForMobileNumber(otpvo.getOtpCode(), otpvo.getMobileNumber());
			if (null != otpDetails) {
				otpvo.setOTPValidate(Boolean.TRUE);
				otpDetails.setOtpvalidate(Boolean.TRUE);
				servicerequestdetails.saveOrUpdateOTPDetails(otpDetails);
				servicerequestdetails.sendSMSForServiceRequest(otpvo.getMobileNumber(), otpvo.getRefrenceNumber());
			} else {
				otpvo.setOTPValidate(Boolean.FALSE);
			}
		}
		return new ResponseEntity<OtpVO>(otpvo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/upload/{mobilenumber}/{serviceType}", method = RequestMethod.POST)
	public ResponseEntity<UploadDocument> uploadDocuemnt(@RequestParam("file") MultipartFile file, @PathVariable String mobilenumber,@PathVariable String serviceType)
			throws Exception {
		UploadDocument docuemntUpload=new UploadDocument();
		if (!file.isEmpty()) {
			try {
		         byte[] bytes = file.getBytes();
               String fileName=serviceType+"_"+System.currentTimeMillis()+".png";
				// Creating the directory to store file
				String rootPath = "/home/logicqso/uploadDocument/";
				File dir = new File(rootPath + File.separator + mobilenumber);
				if (!dir.exists())
					dir.mkdirs();
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				docuemntUpload.setDocumentPath(serverFile.getAbsolutePath());
				docuemntUpload.setMobileNumber(mobilenumber);
				docuemntUpload.setName(serverFile.getName());
				docuemntUpload.setServiceType(serviceType);
				docuemntUpload.setUploadFor("ServiceRequest");
				docuemntUpload.setUploadDate(new Date());
				servicerequestdetails.saveDocumentDetails(docuemntUpload);
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
		}
		return new ResponseEntity<UploadDocument>(docuemntUpload,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/getservicelist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceList> userRegister(@RequestParam(required=false) String dateinterval) throws Exception {
		ServiceList services = new ServiceList();
		if (StringUtils.isEmpty(dateinterval)) {
			services.setDayInterval("LAST 1 DAy");
		} else {
			services.setDayInterval(dateinterval);
		}
		servicerequestdetails.getServiceDetailsAccordingToFilter(services);
		return new ResponseEntity<ServiceList>(services, HttpStatus.OK);
	}
}
