package com.logicq.logicq.ui.user.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "entityAvailabilityBean")
@ViewScoped
public class EntityAvailabilityBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3040063849947424764L;

	private Date avilabledate;

	private String profileid;

	private String entityid;

	private List<EntityAvalAtLocationBean> entityavalloc;
	
	public List<EntityAvalAtLocationBean> getEntityavalloc(){
		return getEntityavalloc( profileid ,avilabledate);
	}

	public List<EntityAvalAtLocationBean> getEntityavalloc(String profileid ,Date date) {
		if(null!=profileid ){
		if(null==entityavalloc){
			entityavalloc=new ArrayList<EntityAvalAtLocationBean>();
		}
		EntityAvalAtLocationBean enavlloc=new EntityAvalAtLocationBean();
		if("Test101".equals(profileid) ){
		enavlloc.setAddresdetails("Pune with gps");
		enavlloc.setLocationid("loc123");
		}else{
			enavlloc.setAddresdetails("Pune2 with gps");
			enavlloc.setLocationid("loc124");
		}
		TimeSlot timeslots=new TimeSlot();
		Map<String, Boolean> allTimeSlot =new HashMap<String, Boolean>();
		allTimeSlot.put("8.00 AM ", true);
		allTimeSlot.put("8.30 AM ", true);
		allTimeSlot.put("9.00 AM ", false);
		allTimeSlot.put("9.30 AM ", true);
		allTimeSlot.put("10.00 AM ", false);
		allTimeSlot.put("9.00 PM ", true);
		allTimeSlot.put("9.30 PM ", true);
		allTimeSlot.put("10.00 PM ", false);
		timeslots.setAllTimeSlot(allTimeSlot);
		enavlloc.setAllTimeSlot(allTimeSlot);
		entityavalloc.add(enavlloc);
		}
		return entityavalloc;
	}

	public void setEntityavalloc(List<EntityAvalAtLocationBean> entityavalloc) {
		this.entityavalloc = entityavalloc;
	}

	public Date getAvilabledate() {
		return avilabledate;
	}

	public void setAvilabledate(Date avilabledate) {
		this.avilabledate = avilabledate;
	}

	public String getProfileid() {
		return profileid;
	}

	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}

	public String getEntityid() {
		return entityid;
	}

	public void setEntityid(String entityid) {
		this.entityid = entityid;
	}


}
