package com.softexploration.lab.bankapp.ext.domain.impl.account.request;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.request.CreateAccountDataRequest;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncRequestId;

public class CreateAccountDataRequestImpl implements CreateAccountDataRequest {

	private static final long serialVersionUID = 2417926956019003327L;

	private AsyncRequestId asyncRequestId;
	private AccountData accountData;

	public CreateAccountDataRequestImpl(AsyncRequestId asyncRequestId, AccountData accountData) {
		super();
		this.asyncRequestId = asyncRequestId;
		this.accountData = accountData;
	}

	public AsyncRequestId getAsyncRequestId() {
		return asyncRequestId;
	}

	public AccountData getAccountData() {
		return accountData;
	}

}
