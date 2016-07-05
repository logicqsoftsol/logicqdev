package com.crm.logicq.dao.readfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.common.MSAcessHelper;
import com.crm.logicq.model.user.CardReadDetails;

/**
 * 
 * 
 * @author Nihar
 *
 */
@Repository("readFileDAO")
public class ReadFileDAO extends AbstractDAO<CardReadDetails> implements IReadFileDAO,IMSAcessQueryConstant{

	@Autowired
	MSAcessHelper msacesshelper;
	
	@Override
	public List<CardReadDetails> readAccessFile() throws Exception {
	return (List<CardReadDetails>) msacesshelper.executeQuery(SELECT_QUERY, CardReadDetails.class);
	}
	
}