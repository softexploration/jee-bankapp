package com.softexploration.lab.bankapp.domain.user.async.impl;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;
import com.softexploration.lab.bankapp.domain.user.async.CreateUserDataAsync;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.impl.user.create.CreateUserDataImpl;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;

public class CreateUserDataAsyncImpl extends CreateUserDataImpl implements CreateUserDataAsync {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1377915180930523879L;

	private AsyncResponseId asyncResponseId;
	private OperationEntryId operationEntryId;

	public CreateUserDataAsyncImpl(UserData userData, AsyncResponseId asyncResponseId,
			OperationEntryId operationEntryId) {
		super(userData);
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
