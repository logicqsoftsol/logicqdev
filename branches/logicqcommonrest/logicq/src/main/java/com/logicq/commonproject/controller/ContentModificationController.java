package com.logicq.commonproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.commonproject.model.ContentDetails;
import com.logicq.commonproject.model.HomeContent;
import com.logicq.commonproject.service.IContentModificationService;

@RestController
@RequestMapping("/admin/content")
public class ContentModificationController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ContentModificationController.class);
	
	@Autowired
	IContentModificationService contentmodificationservice;
	
	
	@RequestMapping(value = "/saveOrUpdateContent", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContentDetails> userRegister(@RequestBody ContentDetails contentDetails) throws Exception {
		if(null==contentmodificationservice){
		return 	new ResponseEntity<ContentDetails>(contentDetails, HttpStatus.BAD_REQUEST);
		}
		if(null!=contentDetails){
			contentmodificationservice.saveorUpdateWebContent(contentDetails);
		}
		return new ResponseEntity<ContentDetails>(contentDetails, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/saveOrUpdateHomeContent", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HomeContent> userRegister(@RequestBody HomeContent homecontent) throws Exception {
		if(null==contentmodificationservice){
		return 	new ResponseEntity<HomeContent>(homecontent, HttpStatus.BAD_REQUEST);
		}
		if(null!=homecontent){
			contentmodificationservice.saveorUpdateHomeWebContent(homecontent);
		}
		return new ResponseEntity<HomeContent>(homecontent, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getHomeContentDetails", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HomeContent>> getHomeContent() throws Exception {
		List<HomeContent> homecontent=contentmodificationservice.getHomeContent();
		return new ResponseEntity<List<HomeContent>>(homecontent, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getContentDetails", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ContentDetails>> getContent() throws Exception {
		List<ContentDetails> contentdetails=contentmodificationservice.getContentDetails();
		return new ResponseEntity<List<ContentDetails>>(contentdetails, HttpStatus.OK);
	}
	
}
