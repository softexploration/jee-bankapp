package com.softexploration.lab.bankapp.ext.accounts.api.sync;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;

public interface AccountServiceSync {

	AccountData getAccount(AccountId id);

}
