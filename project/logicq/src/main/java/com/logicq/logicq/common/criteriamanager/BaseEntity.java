
package com.logicq.logicq.common.criteriamanager;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author SudhanshuLenka
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7531347138687214594L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastupdatetime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createtime;
	
	@Column(name = "created_by")
	private Date createdby;
	
	@Column(name = "updated_by")
	private Date updatedby;
	

	public Date getLastupdatetime() {
	
		return lastupdatetime;
	}

	
	public void setLastupdatetime(Date lastupdatetime) {
	
		this.lastupdatetime = lastupdatetime;
	}

	
	public Date getCreatetime() {
	
		return createtime;
	}

	
	public void setCreatetime(Date createtime) {
	
		this.createtime = createtime;
	}

	
	public Date getCreatedby() {
	
		return createdby;
	}

	
	public void setCreatedby(Date createdby) {
	
		this.createdby = createdby;
	}

	
	public Date getUpdatedby() {
	
		return updatedby;
	}

	
	public void setUpdatedby(Date updatedby) {
	
		this.updatedby = updatedby;
	}


	@Override
	public String toString() {

		return "BaseEntity [lastupdatetime=" + lastupdatetime + ", createtime=" + createtime + ", createdby=" + createdby + ", updatedby=" + updatedby + "]";
	}


	
}
