package com.softexploration.lab.bankapp.accounts.service.validator;

import com.softexploration.lab.bankapp.ext.domain.account.AccountId;

public interface AccountValidator {

	void validate(AccountId id);
}
