package com.softexploration.lab.bankapp.ext.domain.impl.account;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.AccountStatus;
import com.softexploration.lab.bankapp.ext.domain.account.AccountType;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

public class AccountDataImpl implements AccountData {

	private static final long serialVersionUID = 1317514421084766037L;

	private AccountId id;

	private String name1;

	private AccountType accountType;

	private AccountStatus accountStatus;

	private UserId userId;

	public AccountDataImpl(AccountId id, String name1, AccountType accountType,
			AccountStatus accountStatus, UserId userId) {
		super();
		this.id = id;
		this.name1 = name1;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.userId = userId;
	}

	public AccountId getId() {
		return id;
	}

	public String getName1() {
		return name1;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public UserId getUserId() {
		return userId;
	}

}
