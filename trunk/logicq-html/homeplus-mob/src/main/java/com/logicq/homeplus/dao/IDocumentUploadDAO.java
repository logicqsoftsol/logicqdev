package com.logicq.homeplus.dao;

import java.util.Date;
import java.util.List;

import com.logicq.homeplus.model.UploadDocument;

public interface IDocumentUploadDAO {
	
	void saveDocumentDetails(UploadDocument uploadDocument);
	List<UploadDocument> getDocumentsAccordingToDate(Date inputDate);
	
	List<UploadDocument> getDocumentsAccordingToDate(Date inputDate,long userid);
	UploadDocument getDocuemnt(long docuemntid);
	

}
