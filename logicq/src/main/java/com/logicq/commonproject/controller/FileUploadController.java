package com.logicq.commonproject.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.logicq.commonproject.service.IFileUploadService;

@RestController
@RequestMapping("/admin/file")
@MultipartConfig(fileSizeThreshold = 20971520)
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@Autowired
	IFileUploadService fileuploadservice;

	@RequestMapping(value = "/uploadfiles/{findFolder}", method = { RequestMethod.POST, RequestMethod.GET })
	public String uploadFile(@RequestParam("uploadedFile") MultipartFile uploadedFileRef, @PathVariable("findFolder") String findFolder) {

		// Get name of uploaded file.		
		String fileName = uploadedFileRef.getOriginalFilename();
		// Path where the uploaded file will be stored.
		String path = "D://datlib/" + findFolder + "/" + fileName;
		// This buffer will store the data read from 'uploadedFileRef'
		try {
			FileCopyUtils.copy(uploadedFileRef.getBytes(), new FileOutputStream(path + uploadedFileRef.getOriginalFilename()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "File uploaded successfully! ";
	}
}