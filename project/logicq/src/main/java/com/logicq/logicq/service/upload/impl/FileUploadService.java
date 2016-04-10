package com.logicq.logicq.service.upload.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.conversion.fileupload.FileUploadConversion;
import com.logicq.logicq.dao.upload.IFileUploadDAO;
import com.logicq.logicq.model.upload.UploadFile;
import com.logicq.logicq.service.upload.IFileUploadService;
import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;

public class FileUploadService implements IFileUploadService {

	FileUploadConversion fileuploadConversion = FileUploadConversion.getInstance();
	@Autowired
	private IFileUploadDAO fileUploadDAO;

	public IFileUploadDAO getFileUploadDAO() {

		return fileUploadDAO;
	}

	public void setFileUploadDAO(IFileUploadDAO fileUploadDAO) {

		this.fileUploadDAO = fileUploadDAO;
	}

	public void save(FileUploadRequest uploadFileRequest, FileUploadResponse uploadFileResponse) {

		UploadFile uploadFile = fileuploadConversion.handleConversionVOtoEntityWithContext(uploadFileRequest.getFileupload());
		ImageInputStream input = null;
		byte[] data = uploadFileRequest.getFileupload().getData();
		try {
			String path = "D:\\image\\" + uploadFile.getUserId() + ".jpg";
			File dest = new File(path);
			input = ImageIO.createImageInputStream(new ByteArrayInputStream(data));
			BufferedImage image = ImageIO.read(input);
			boolean isImageWritten = ImageIO.write(image, "jpg", dest);
			if (isImageWritten) {
				uploadFile.setQualifiedPath(path);
				fileUploadDAO.save(uploadFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public void delete(FileUploadRequest uploadFileRequest, FileUploadResponse uploadFileResponse) {

		fileUploadDAO.delete(fileuploadConversion.handleConversionVOtoEntityWithContext(uploadFileRequest.getFileupload()));
	}
}
