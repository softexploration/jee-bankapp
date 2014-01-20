package com.softexploration.lab.bankapp.accounts.oper.reqister.impl;

import java.util.Date;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationStatus;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationType;

public class OperationEntryImpl implements OperationEntry {

	private OperationEntryId id;
	private OperationType operationType;
	private OperationStatus operationStatus;
	private Long internalId;
	private Long externalId;
	private Date requestTime;

	public OperationEntryImpl(OperationEntryId id, OperationType operationType,
			OperationStatus operationStatus, Long internalId, Long externalId, Date requestTime) {
		this.id = id;
		this.operationType = operationType;
		this.operationStatus = operationStatus;
		this.internalId = internalId;
		this.externalId = externalId;
		this.requestTime = requestTime;
	}

	public OperationEntryId getId() {
		return id;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public OperationStatus getOperationStatus() {
		return operationStatus;
	}

	public Long getInternalId() {
		return internalId;
	}

	public Long getExternalId() {
		return externalId;
	}

	public Date getRequestTime() {
		return requestTime;
	}

}
