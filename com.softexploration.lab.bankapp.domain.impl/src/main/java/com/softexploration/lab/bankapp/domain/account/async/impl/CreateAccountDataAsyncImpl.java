package com.softexploration.lab.bankapp.domain.account.async.impl;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;
import com.softexploration.lab.bankapp.domain.account.async.CreateAccountDataAsync;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.impl.account.create.CreateAccountDataImpl;

public class CreateAccountDataAsyncImpl extends CreateAccountDataImpl implements
		CreateAccountDataAsync {

	private static final long serialVersionUID = 851093138080609716L;

	private AsyncResponseId asyncResponseId;
	private OperationEntryId operationEntryId;

	public CreateAccountDataAsyncImpl(AccountData data, AsyncResponseId asyncResponseId,
			OperationEntryId operationEntryId) {
		super(data);
		this.asyncResponseId = asyncResponseId;
		this.operationEntryId = operationEntryId;
	}

	public AsyncResponseId getAsyncResponseId() {
		return asyncResponseId;
	}

	public OperationEntryId getOperationEntryId() {
		return operationEntryId;
	}
}
