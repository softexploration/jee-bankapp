package com.softexploration.lab.bankapp.accounts.oper.reqister.impl;

import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationRegisterService;
import com.softexploration.lab.bankapp.accounts.oper.reqister.data.OperationRegisterDataService;

@Stateless
@Local(OperationRegisterService.class)
public class DefaultOperationRegisterService implements OperationRegisterService {

	@EJB
	private OperationRegisterDataService operationRegisterDataService;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public OperationEntry reqister(OperationEntry entry) {
		return operationRegisterDataService.reqister(entry);
	}

	public OperationEntry get(OperationEntryId id) {
		return operationRegisterDataService.get(id);
	}

	public Long generateInternalRequestId() {
		return new Random().nextLong();
	}

}
