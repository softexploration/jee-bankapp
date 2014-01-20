package com.softexploration.lab.bankapp.ext.accounts.api;

import com.softexploration.lab.bankapp.ext.accounts.api.async.AccountServiceAsync;
import com.softexploration.lab.bankapp.ext.accounts.api.sync.AccountServiceSync;

public interface AccountService extends AccountServiceSync, AccountServiceAsync {

}
