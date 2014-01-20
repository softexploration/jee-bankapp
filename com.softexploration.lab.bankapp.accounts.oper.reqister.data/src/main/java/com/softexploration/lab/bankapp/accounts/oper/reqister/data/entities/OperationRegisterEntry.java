package com.softexploration.lab.bankapp.accounts.oper.reqister.data.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationStatus;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationType;

@Entity
@Table(name = "oper_register")
public class OperationRegisterEntry implements Serializable {

	private static final long serialVersionUID = 6681411398340681687L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "oper_type")
	@Enumerated(EnumType.STRING)
	private OperationType operationType;

	@Column(name = "internal_id")
	private Long internalId;

	@Column(name = "external_id")
	private Long externalId;

	@Column(name = "req_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestTime;

	@Column(name = "oper_status")
	@Enumerated(EnumType.STRING)
	private OperationStatus operationStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Long getInternalId() {
		return internalId;
	}

	public void setInternalId(Long internalId) {
		this.internalId = internalId;
	}

	public Long getExternalId() {
		return externalId;
	}

	public void setExternalId(Long externalId) {
		this.externalId = externalId;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public OperationStatus getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(OperationStatus operationStatus) {
		this.operationStatus = operationStatus;
	}

}
