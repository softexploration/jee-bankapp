package com.softexploration.lab.bankapp.accounts.service.validator.impl;

import com.softexploration.lab.bankapp.accounts.service.validator.AccountValidator;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.cmn.exception.ServiceException;

public class DefaultAccountValidator implements AccountValidator {

	public void validate(AccountId id) {
		if (id == null) {
			throw new ServiceException("AccountId is not set");
		}
		if (id.getNumber() == null) {
			throw new ServiceException("AccountId value is not set");
		}
	}

}
