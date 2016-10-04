package com.logicq.commonproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.logicq.commonproject.model.ContentDetails;
import com.logicq.commonproject.service.IContentModificationService;

@Controller
@RequestMapping("/admin/content")
public class ContentModificationController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ContentModificationController.class);
	
	@Autowired
	IContentModificationService contentmodificationservice;
	
	
	@RequestMapping(value = "/saveOrUpdateContent", method = RequestMethod.POST)
	public ResponseEntity<ContentDetails> userRegister(@RequestBody ContentDetails contentDetails) throws Exception {
		if(null==contentmodificationservice){
		return 	new ResponseEntity<ContentDetails>(contentDetails, HttpStatus.BAD_REQUEST);
		}
		if(null!=contentDetails){
			contentmodificationservice.saveorUpdateWebContent(contentDetails);
		}
		return new ResponseEntity<ContentDetails>(contentDetails, HttpStatus.OK);
	}
	
	
}
