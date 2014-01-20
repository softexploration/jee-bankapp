package com.softexploration.lab.bankapp.accounts.service.validator.provider;

import com.softexploration.lab.bankapp.accounts.service.validator.AccountValidator;
import com.softexploration.lab.bankapp.accounts.service.validator.impl.DefaultAccountValidator;

public class AccountValidatorProvider {

	private static AccountValidator validatorInstance;

	public static AccountValidator getValidatorInstance() {
		if (validatorInstance == null) {
			validatorInstance = new DefaultAccountValidator();
		}
		return validatorInstance;
	}
}
