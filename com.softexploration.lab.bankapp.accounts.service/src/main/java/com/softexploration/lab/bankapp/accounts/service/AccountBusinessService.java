package com.softexploration.lab.bankapp.accounts.service;

import java.util.List;

import javax.ejb.Local;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

@Local
public interface AccountBusinessService {

	AccountData getAccount(AccountId id);

	AccountData createAccount(CreateAccountData data);

	List<AccountData> getAllAccounts();

	List<AccountData> getAccountsForUser(UserId userId);
}
