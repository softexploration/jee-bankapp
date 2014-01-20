package com.softexploration.lab.bankapp.domain.account.async;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;


public interface CreateAccountDataAsync extends CreateAccountData {

	AsyncResponseId getAsyncResponseId();
	
	OperationEntryId getOperationEntryId();
}
