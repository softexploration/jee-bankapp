package com.softexploration.lab.bankapp.accounts.service.create.process.proxy.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.softexploration.lab.bankapp.accounts.service.AccountBusinessService;
import com.softexploration.lab.bankapp.accounts.service.create.process.proxy.AccountBusinessServiceProxy;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

@Stateless
@Local(AccountBusinessServiceProxy.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DefaultAccountBusinessServiceProxy implements AccountBusinessServiceProxy {

	private AccountBusinessService accountsBusinessServices;

	@EJB
	public void setAccountsBusinessServices(AccountBusinessService accountsBusinessServices) {
		this.accountsBusinessServices = accountsBusinessServices;
	}

	public AccountData getAccount(AccountId id) {
		return accountsBusinessServices.getAccount(id);
	}

	public AccountData createAccount(CreateAccountData data) {
		return accountsBusinessServices.createAccount(data);
	}

	public List<AccountData> getAllAccounts() {
		return accountsBusinessServices.getAllAccounts();
	}

	public List<AccountData> getAccountsForUser(UserId userId) {
		return accountsBusinessServices.getAccountsForUser(userId);
	}

}
