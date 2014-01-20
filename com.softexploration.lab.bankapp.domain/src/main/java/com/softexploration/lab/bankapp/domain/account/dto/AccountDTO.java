package com.softexploration.lab.bankapp.domain.account.dto;

import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.AccountStatus;
import com.softexploration.lab.bankapp.ext.domain.account.AccountType;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

public interface AccountDTO {

	AccountId getId();

	String getName1();

	AccountType getAccountType();

	AccountStatus getAccountStatus();

	UserId getUserId();
}
