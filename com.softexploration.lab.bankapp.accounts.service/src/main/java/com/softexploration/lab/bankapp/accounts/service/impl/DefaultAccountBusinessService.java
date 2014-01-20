package com.softexploration.lab.bankapp.accounts.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import com.softexploration.lab.bankapp.accounts.data.AccountDataService;
import com.softexploration.lab.bankapp.accounts.service.AccountBusinessService;
import com.softexploration.lab.bankapp.accounts.service.converter.provider.DTO2BusinessTypeConverterProvider;
import com.softexploration.lab.bankapp.accounts.service.interceptor.CreateAccountValidationInterceptor;
import com.softexploration.lab.bankapp.accounts.service.validator.provider.AccountValidatorProvider;
import com.softexploration.lab.bankapp.domain.account.dto.AccountDTO;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.cmn.exception.EntityNotFoundDataServiceException;
import com.softexploration.lab.bankapp.ext.domain.cmn.exception.ServiceException;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DefaultAccountBusinessService implements AccountBusinessService {

	@Resource
	private SessionContext ctx;

	private AccountDataService accountDataService;

	@EJB
	public void setAccountDataService(AccountDataService accountDataService) {
		this.accountDataService = accountDataService;
	}

	public AccountData getAccount(AccountId id) {
		AccountValidatorProvider.getValidatorInstance().validate(id);
		try {
			AccountDTO account = accountDataService.getAccount(id);
			return DTO2BusinessTypeConverterProvider.getConverterInstance().convert(account);
		} catch (EntityNotFoundDataServiceException ex) {
			throw new ServiceException("Account for id [" + id.getNumber() + "] does not exist.");
		}
	}

	@Interceptors(CreateAccountValidationInterceptor.class)
	public AccountData createAccount(CreateAccountData data) {
		AccountDTO account = accountDataService.createAccount(data);
		return DTO2BusinessTypeConverterProvider.getConverterInstance().convert(account);
	}

	public List<AccountData> getAllAccounts() {
		return DTO2BusinessTypeConverterProvider.getConverterInstance().convert(
				accountDataService.getAllAccounts());
	}

	public List<AccountData> getAccountsForUser(UserId userId) {
		return DTO2BusinessTypeConverterProvider.getConverterInstance().convert(
				accountDataService.getAccountsForUser(userId));
	}

}
