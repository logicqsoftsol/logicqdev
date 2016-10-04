package com.logicq.commonproject.controller;


import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.logicq.commonproject.helper.PropertyHelper;
import com.logicq.commonproject.model.FileUpload;
import com.logicq.commonproject.service.IFileUploadService;
import com.logicq.commonproject.vo.FileUploadVO;


@Controller
@RequestMapping("/admin/file")
public class FileUploadController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);

	@Autowired
	IFileUploadService fileuploadservice;
	
	@RequestMapping(value = "/uploadfiles", method = RequestMethod.POST)
	public ResponseEntity<String> userRegister(@RequestBody FileUploadVO fileuploadvo) throws Exception {
		if (null != fileuploadvo) {
			String filepath = PropertyHelper.loadProperty().getProperty("filepath");
			MultipartFile[] files = fileuploadvo.getFilecontent();
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					FileUpload fileupload = new FileUpload();
					fileupload.setCategory(fileuploadvo.getCategory());
					fileupload.setDisplaysubtitle(fileuploadvo.getDisplaysubtitle());
					fileupload.setDisplaytitle(fileuploadvo.getDisplaytitle());
					fileupload.setName(file.getOriginalFilename());
					fileupload.setPath(filepath);
					fileupload.setSubcategory(fileuploadvo.getSubcategory());
					fileupload.setTooltip(fileuploadvo.getTooltip());
					fileupload.setType(file.getContentType());
					fileupload.setFilesize(file.getSize() / 1024 + "KB");
					fileuploadservice.uploadFile(fileupload);
					FileCopyUtils.copy(file.getBytes(), new FileOutputStream(filepath + file.getOriginalFilename()));
				}
			}
		}

		return new ResponseEntity<String>("You successfully uploaded file", HttpStatus.OK);
	}
	
}