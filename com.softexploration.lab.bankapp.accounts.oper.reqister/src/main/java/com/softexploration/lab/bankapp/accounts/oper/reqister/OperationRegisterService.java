package com.softexploration.lab.bankapp.accounts.oper.reqister;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;

public interface OperationRegisterService {

	OperationEntry reqister(OperationEntry entry);

	OperationEntry get(OperationEntryId id);

	Long generateInternalRequestId();
}
