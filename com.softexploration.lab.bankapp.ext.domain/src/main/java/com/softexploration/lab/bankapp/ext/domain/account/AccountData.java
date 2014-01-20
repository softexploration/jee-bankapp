package com.softexploration.lab.bankapp.ext.domain.account;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.user.UserId;

public interface AccountData extends Serializable {

	AccountId getId();

	String getName1();

	AccountType getAccountType();

	AccountStatus getAccountStatus();

	UserId getUserId();
}
