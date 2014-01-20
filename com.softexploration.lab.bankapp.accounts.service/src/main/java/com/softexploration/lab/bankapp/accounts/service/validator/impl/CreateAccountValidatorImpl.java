package com.softexploration.lab.bankapp.accounts.service.validator.impl;

import com.softexploration.lab.bankapp.accounts.service.validator.CreateAccountValidator;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.account.exception.CreateAccountException;

public class CreateAccountValidatorImpl implements CreateAccountValidator {

	public void validate(CreateAccountData data) {
		if (data == null) {
			throw new CreateAccountException("CreateAccountData is not provided");
		}
	}

}
