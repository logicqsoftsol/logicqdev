
package com.logicq.logicq.controller.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.logicq.logicq.dao.upload.IFileUploadDAO;
import com.logicq.logicq.ui.fileupload.vo.FileUploadVO;

@Controller
@RequestMapping("/controller")
public class FileUploadController {

	LinkedList<FileUploadVO> files = new LinkedList<FileUploadVO>();
	FileUploadVO fileMeta = null;
	@Autowired
	public IFileUploadDAO fileUploadDao;

	public IFileUploadDAO getFileUploadDao() {

		return fileUploadDao;
	}

	public void setFileUploadDao(IFileUploadDAO fileUploadDao) {

		this.fileUploadDao = fileUploadDao;
	}

	/***************************************************
	 * URL: /rest/controller/upload upload(): receives files
	 * 
	 * @param request
	 *            : MultipartHttpServletRequest auto passed
	 * @param response
	 *            : HttpServletResponse auto passed
	 * @return LinkedList<FileMeta> as json format
	 ****************************************************/
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileUploadVO> upload(MultipartHttpServletRequest request, HttpServletResponse response) {

		//1. build an iterator
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		//2. get each file
		while (itr.hasNext()) {
			//2.1 get next MultipartFile
			mpf = request.getFile(itr.next());
			System.out.println(mpf.getOriginalFilename() + " uploaded! " + files.size());
			//2.2 if files > 10 remove the first from the list
			if (files.size() >= 10)
				files.pop();
			//2.3 create new fileMeta
			fileMeta = new FileUploadVO();
			fileMeta.setFileName(mpf.getOriginalFilename());
			fileMeta.setFileSize(mpf.getSize() / 1024 + "KB");
			fileMeta.setFileType(mpf.getContentType());
			try {
				//fileMeta.setData(mpf.getBytes());
				// copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream("D:/temp/files/" + mpf.getOriginalFilename()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//2.4 add to files
			files.add(fileMeta);
		}
		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
		return files;
	}

	/***************************************************
	 * URL: /rest/controller/get/{value} get(): get file as an attachment
	 * 
	 * @param response
	 *            : passed by the server
	 * @param value
	 *            : value from the URL
	 * @return void
	 ****************************************************/
	@RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
	public void get(HttpServletResponse response, @PathVariable String value) {

		FileUploadVO getFile = files.get(Integer.parseInt(value));
	//	try {
			response.setContentType(getFile.getFileType());
			response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
			//FileCopyUtils.copy(getFile.getData(), response.getOutputStream());
	//	} catch Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}
}
