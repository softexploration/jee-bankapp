package com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.impl;

import com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.CreateAccountSuccess;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public class CreateAccountSuccessImpl implements CreateAccountSuccess {

	private static final long serialVersionUID = 8054936558435445671L;

	private AsyncResponseId asyncResponseId;
	private AccountData accountData;

	public CreateAccountSuccessImpl(AsyncResponseId asyncResponseId, AccountData accountData) {
		this.asyncResponseId = asyncResponseId;
		this.accountData = accountData;
	}

	public AccountData getAccountData() {
		return accountData;
	}

	public AsyncResponseId getAsyncResponseId() {
		return asyncResponseId;
	}

}
