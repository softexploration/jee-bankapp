package com.softexploration.lab.bankapp.accounts.data;

import java.util.List;

import javax.ejb.Local;

import com.softexploration.lab.bankapp.domain.account.dto.AccountDTO;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.account.update.UpdateAccountData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

@Local
public interface AccountDataService {

	AccountDTO createAccount(CreateAccountData data);

	AccountDTO getAccount(AccountId id);

	AccountDTO updateAccount(UpdateAccountData data);

	AccountDTO removeAccount(AccountId id);
	
	List<AccountDTO> getAllAccounts();

	List<AccountDTO> getAccountsForUser(UserId userId);
}
