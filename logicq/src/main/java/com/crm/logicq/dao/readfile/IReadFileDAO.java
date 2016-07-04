package com.crm.logicq.dao.readfile;

import java.util.List;

import com.crm.logicq.model.user.CardReadDetails;

public interface IReadFileDAO {
	
	public List<CardReadDetails> readAccessFile() throws Exception;

}
