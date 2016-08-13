package com.crm.logicq.dao.readfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.common.MSAcessHelper;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.security.helper.DateHelper;

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
		String attednacequery="select Punch_month,Card_Number,Att_PunchRecDate  "
				+ " from Tran_DeviceAttRec where Punch_month=#"+DateHelper.convertTodayDatetoStringWituoutTime()+"#";
	return (List<CardReadDetails>) msacesshelper.executeQuery(attednacequery, CardReadDetails.class);
	}
	
	
	
}