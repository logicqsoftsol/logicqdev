package com.logicq.logicq.ui.user.bean;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "timeSlot")
@ViewScoped
public class TimeSlot {
	
	public Map<String, Boolean> getAllTimeSlot() {
		return allTimeSlot;
	}

	public void setAllTimeSlot(Map<String, Boolean> allTimeSlot) {
		this.allTimeSlot = allTimeSlot;
	}

	private Map< String,Boolean>  allTimeSlot;

}
