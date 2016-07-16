package com.crm.logicq.dao.readfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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