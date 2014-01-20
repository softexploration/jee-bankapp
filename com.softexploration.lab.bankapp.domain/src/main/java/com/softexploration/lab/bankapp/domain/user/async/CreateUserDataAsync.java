package com.softexploration.lab.bankapp.domain.user.async;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;


public interface CreateUserDataAsync extends CreateUserData {

	AsyncResponseId getAsyncResponseId();
	
	OperationEntryId getOperationEntryId();
}
