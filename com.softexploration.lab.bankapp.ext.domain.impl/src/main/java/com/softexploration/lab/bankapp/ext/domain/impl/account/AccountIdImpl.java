package com.softexploration.lab.bankapp.ext.domain.impl.account;

import com.softexploration.lab.bankapp.ext.domain.account.AccountId;

public class AccountIdImpl implements AccountId {

	private static final long serialVersionUID = -7037406386863784843L;

	private String number;

	public AccountIdImpl(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

}
