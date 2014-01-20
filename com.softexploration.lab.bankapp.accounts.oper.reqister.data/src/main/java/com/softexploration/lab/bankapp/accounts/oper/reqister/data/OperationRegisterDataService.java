package com.softexploration.lab.bankapp.accounts.oper.reqister.data;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;

public interface OperationRegisterDataService {

	OperationEntry reqister(OperationEntry entry);

	OperationEntry get(OperationEntryId id);
}
