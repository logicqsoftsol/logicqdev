package com.logicq.logicq.service.upload.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.conversion.fileupload.FileUploadConversion;
import com.logicq.logicq.dao.upload.IFileUploadDAO;
import com.logicq.logicq.model.upload.UploadFile;
import com.logicq.logicq.service.upload.IFileUploadService;
import com.logicq.logicq.service.user.impl.UserService;
import com.logicq.logicq.ui.fileupload.vo.FileUploadVO;

@Service
@Transactional
public class FileUploadService implements IFileUploadService {

	public final static Logger logger = Logger.getLogger(UserService.class);
	FileUploadConversion fileuploadConversion = FileUploadConversion.getInstance();
	@Autowired
	private IFileUploadDAO fileUploadDAO;


//	public void save(FileUploadRequest uploadFileRequest, FileUploadResponse uploadFileResponse) {
//
//		UploadFile uploadFile = fileuploadConversion.handleConversionVOtoEntityWithContext(uploadFileRequest.getFileupload());
//		ImageInputStream input = null;
//		byte[] data = uploadFileRequest.getFileupload().getData();
//		String destinationPath = uploadFileRequest.getFileupload().getDestinationPath();
//		try {
//			String path = destinationPath + uploadFile.getUserId() + ".jpg";
//			File dest = new File(path);
//			input = ImageIO.createImageInputStream(new ByteArrayInputStream(data));
//			BufferedImage image = ImageIO.read(input);
//			boolean isImageWritten = ImageIO.write(image, "jpg", dest);
//			if (isImageWritten) {
//				uploadFile.setQualifiedPath(path);
//				fileUploadDAO.save(uploadFile);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//		}
//	}


	public void uploadfile(FileUploadVO fileuploadvo) {
		try {
			UploadFile uploadFile = fileuploadConversion.handleConversionVOtoEntityWithContext(fileuploadvo);
			String destinationPath = fileuploadvo.getDestinationPath();
			String path = destinationPath + uploadFile.getUserId() + fileuploadvo.getFileType();
			File dest = new File(path);
			
			fileUploadDAO.save(uploadFile);
			if ("jpg".equalsIgnoreCase(fileuploadvo.getFileType())) {
				uploadFile.setQualifiedPath(path);
				BufferedImage image = ImageIO.read(fileuploadvo.getFile().getInputStream());
				ImageIO.write(image, "jpg", dest);
			}
					
		} catch (IOException exp) {
			logger.error(" uploadfile : Unable to upload file :" + exp.getMessage(), exp);
		}
	}
}
