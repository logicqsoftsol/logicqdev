package com.crm.logicq.vo.attendance;

import com.crm.logicq.vo.user.UserVO;

public class AttendanceAbsentDetails {
	
	private UserVO userdetails;
	
	private CardDetailsVO cardetails;

	public UserVO getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserVO userdetails) {
		this.userdetails = userdetails;
	}

	public CardDetailsVO getCardetails() {
		return cardetails;
	}

	public void setCardetails(CardDetailsVO cardetails) {
		this.cardetails = cardetails;
	}

	@Override
	public String toString() {
		return "AttendanceAbsentDetails [userdetails=" + userdetails + ", cardetails=" + cardetails + "]";
	}
	
	

}
