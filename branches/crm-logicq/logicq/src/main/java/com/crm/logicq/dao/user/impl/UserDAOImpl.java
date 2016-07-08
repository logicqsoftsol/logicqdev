package com.crm.logicq.dao.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.common.criteriamanager.LogicqCriteriaHandler;
import com.crm.logicq.dao.sms.ISmsDAO;
import com.crm.logicq.dao.user.IUserDAO;
import com.crm.logicq.dao.user.UserConstant;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.model.user.User;


@Repository
public class UserDAOImpl extends AbstractDAO<User> implements IUserDAO{

	@Autowired
	ISmsDAO smsdao;
	
	@Override
	public List<User> loadUsers() {
		return (List<User>) loadClass(User.class);
	}

	
	@Override
	public void insertSMSDetails(List<SMSDetails> smsdetails) {
		smsdao.insertSMSDetails(smsdetails);
	}


	@Override
	public void getUser(String cardid) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<AttendanceDetails> getAttendanceDetails(AttendanceCriteria attendancecriteria) throws Exception {
		Criteria criteria = getCurrentSession().createCriteria(AttendanceDetails.class);

		if (null != attendancecriteria.getFromdate() && null != attendancecriteria.getTodate()) {
			criteria.add(
					Restrictions.between("date", attendancecriteria.getFromdate(), attendancecriteria.getTodate()));
		}
		if (attendancecriteria.getCardno() != null) {
			criteria.add(Restrictions.eq("user.idetificationid", attendancecriteria.getCardno()));
		}
		if (attendancecriteria.getCardno() != null) {
			criteria.add(Restrictions.eq("user.idetificationid", attendancecriteria.getCardno()));
		}
		if (attendancecriteria.getMobileno() != null) {
			criteria.add(Restrictions.eq("user.communication.mobilenumber", attendancecriteria.getMobileno()));
		}
		if (attendancecriteria.getUserid() != null) {
			criteria.add(Restrictions.eq("user.userid", attendancecriteria.getUserid()));
		}
		return criteria.list();
	
	}

	
}
