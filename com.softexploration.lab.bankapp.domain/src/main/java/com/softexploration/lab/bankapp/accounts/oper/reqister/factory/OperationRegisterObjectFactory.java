package com.softexploration.lab.bankapp.accounts.oper.reqister.factory;

import java.util.Date;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationStatus;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationType;
import com.softexploration.lab.bankapp.accounts.oper.reqister.impl.OperationEntryIdImpl;
import com.softexploration.lab.bankapp.accounts.oper.reqister.impl.OperationEntryImpl;

public class OperationRegisterObjectFactory {

	private static OperationRegisterObjectFactory instance;

	private OperationRegisterObjectFactory() {
	}

	public static OperationRegisterObjectFactory getInstance() {
		if (instance == null) {
			instance = new OperationRegisterObjectFactory();
		}
		return instance;
	}

	public OperationEntry createOperationEntry(OperationEntryId id, OperationType operationType,
			OperationStatus operationStatus, Long internalId, Long externalId, Date requestTime) {
		OperationEntryImpl ret = new OperationEntryImpl(id, operationType, operationStatus,
				internalId, externalId, requestTime);
		return ret;
	}

	public OperationEntryId createOperationEntryId(Long id) {
		OperationEntryIdImpl ret = new OperationEntryIdImpl(id);
		return ret;
	}
}
