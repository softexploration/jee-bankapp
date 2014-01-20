package com.softexploration.lab.bankapp.ext.domain.impl.account.create;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;

public class CreateAccountDataImpl implements CreateAccountData {

	private static final long serialVersionUID = -4942945140114711674L;

	private AccountData accountData;

	public CreateAccountDataImpl(AccountData accountData) {
		super();
		this.accountData = accountData;
	}

	public AccountData getAccountData() {
		return accountData;
	}

}
