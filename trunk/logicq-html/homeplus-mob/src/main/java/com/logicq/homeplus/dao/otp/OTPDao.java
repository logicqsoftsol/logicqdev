package com.logicq.homeplus.dao.otp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.homeplus.dao.AbstractDAO;
import com.logicq.homeplus.model.OTPDetails;

@Repository
public class OTPDao extends AbstractDAO<OTPDetails> implements IOTPDao  {

	@Override
	public void saveOrUpdateOTPDetails(OTPDetails otpdetails) {
		saveOrUpdate(otpdetails);
	}

	@Override
	public OTPDetails validateOTPForMobileNumber(int opt, String mobilenumber) {
		String sql = " from OTPDetails od where od.key.mobilenumber= '" + mobilenumber + "'" + " and od.key.otpnumber=" + opt;
		List<OTPDetails> otpdetails = (List<OTPDetails>) execcuteQuery(sql);
		if(null!=otpdetails  && !otpdetails.isEmpty()){
			return otpdetails.get(0);
		}
		return null;
	}
	


}
