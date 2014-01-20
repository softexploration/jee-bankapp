package com.softexploration.lab.bankapp.accounts.service.validator;

import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;

public interface CreateAccountValidator {

	void validate(CreateAccountData data);
}
