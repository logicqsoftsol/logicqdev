package com.logicq.homeplus.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.homeplus.model.UploadDocument;

@Repository
public class DocumentUploadDAO  extends AbstractDAO<UploadDocument> implements IDocumentUploadDAO{

	@Override
	public void saveDocumentDetails(UploadDocument uploadDocument) {
		save(uploadDocument);
	}

	@Override
	public List<UploadDocument> getDocumentsAccordingToDate(Date inputDate) {
		StringBuilder query=new StringBuilder();
		query.append(" from UploadDocument ud where ud.uploadDate='"+inputDate+"'");
		return (List<UploadDocument>) execcuteQuery(query.toString());
	}

	@Override
	public List<UploadDocument> getDocumentsAccordingToDate(Date inputDate, long userid) {
		StringBuilder query=new StringBuilder();
		query.append(" from UploadDocument ud where ud.uploadDate='"+inputDate+"' and ud.userID="+userid+"" );
		return (List<UploadDocument>) execcuteQuery(query.toString());
	}

	@Override
	public UploadDocument getDocuemnt(long documentID) {
		StringBuilder query=new StringBuilder();
		query.append(" from UploadDocument ud where ud.documentID='"+documentID+"'" );
		return execcuteQueryForUnique(query.toString());
	}

}
