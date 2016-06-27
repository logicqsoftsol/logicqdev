package com.crm.logicq.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATUS_DETAILS")
public class StatusDetails {
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TXN_CODE", nullable = true)
	private String txncode;
	
	@Column(name = "STATUS", nullable = true)
	private String status;
	
	@Column(name = "COMMENT", nullable = true)
	private String comment;
	
	@Column(name = "REASONE", nullable = true)
	private String reasone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxncode() {
		return txncode;
	}

	public void setTxncode(String txncode) {
		this.txncode = txncode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReasone() {
		return reasone;
	}

	public void setReasone(String reasone) {
		this.reasone = reasone;
	}

	@Override
	public String toString() {
		return "StatusDetails [id=" + id + ", txncode=" + txncode + ", status=" + status + ", comment=" + comment
				+ ", reasone=" + reasone + "]";
	}
	
	

}
