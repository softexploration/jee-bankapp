package com.softexploration.lab.bankapp.accounts.oper.reqister;

import java.io.Serializable;
import java.util.Date;

public interface OperationEntry extends Serializable {

	OperationEntryId getId();

	OperationType getOperationType();

	OperationStatus getOperationStatus();

	Long getInternalId();

	Long getExternalId();

	Date getRequestTime();
}
