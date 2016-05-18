package com.logicq.logicq.dao.upload;

import com.logicq.logicq.model.upload.UploadFile;

public interface IFileUploadDAO {
	void save(UploadFile uploadFile);
	
	void delete(UploadFile uploadid);
}
