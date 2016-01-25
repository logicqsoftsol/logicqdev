
package com.logicq.logicq.ui.fileupload.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.logicq.logicq.common.LogicqContextProvider;

@ManagedBean(name = "fileuploadMB")
@RequestScoped
public class FileUploadBean implements Serializable {

	 UploadedFile file;
	
	
	public UploadedFile getFile() {
	
		return file;
	}

	
	public void setFile(UploadedFile file) {
	
		this.file = file;
	}

	public void upload() throws IOException{
	
	}

	public void handleFileUpload(FileUploadEvent event) {
		this.file = event.getFile();
		FileUploadManagedBean fileUploadManagedBean = LogicqContextProvider.getApplicationContext().getBean(FileUploadManagedBean.class);
			fileUploadManagedBean.upload(this);
	
	}
}
