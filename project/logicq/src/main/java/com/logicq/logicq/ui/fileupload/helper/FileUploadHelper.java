package com.logicq.logicq.ui.fileupload.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.facade.upload.IFileUploadFacade;
import com.logicq.logicq.ui.fileupload.bean.FileUploadBean;
import com.logicq.logicq.ui.fileupload.vo.FileUploadRequest;
import com.logicq.logicq.ui.fileupload.vo.FileUploadResponse;
import com.logicq.logicq.ui.fileupload.vo.FileUploadVO;

public class FileUploadHelper {

	@Autowired
	IFileUploadFacade fileUploadFacade;

	public IFileUploadFacade getFileUploadFacade() {

		return fileUploadFacade;
	}

	public void setFileUploadFacade(IFileUploadFacade fileUploadFacade) {

		this.fileUploadFacade = fileUploadFacade;
	}

	public void uploadDocument(FileUploadRequest uploadFileRequest, FileUploadResponse uploadFileResponse) {

		fileUploadFacade.save(uploadFileRequest, uploadFileResponse);
	}

	public static FileUploadBean conversionVOtoUI(FileUploadVO uploadvo, FileUploadBean uploadbean) {

		return uploadbean;
	}

	public static FileUploadVO conversionUItoVO(FileUploadBean uploadbean, FileUploadVO uploadvo) {

		try {
			UploadedFile fileuploaded = uploadbean.getFile();
			InputStream inputStream;
			inputStream = fileuploaded.getInputstream();
			byte[] fileuploaddata = new byte[5120000];
			inputStream.read(fileuploaddata);
			uploadvo.setData(fileuploaddata);
			uploadvo.setFileType(uploadbean.getFile().getContentType());
			uploadvo.setFileName(uploadbean.getFile().getFileName());
			uploadvo.setFileSize(uploadbean.getFile().getSize() + "KB");
			uploadvo.setUploadDate(new Date());
			uploadvo.setUserid(Long.valueOf(1000));
			uploadvo.setInputStream(inputStream);
			//inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uploadvo;
	}
}
