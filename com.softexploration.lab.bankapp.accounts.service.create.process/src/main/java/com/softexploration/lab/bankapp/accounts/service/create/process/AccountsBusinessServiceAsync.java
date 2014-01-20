package com.softexploration.lab.bankapp.accounts.service.create.process;

import javax.ejb.Local;

import com.softexploration.lab.bankapp.domain.account.async.CreateAccountDataAsync;

@Local
public interface AccountsBusinessServiceAsync {

	void processCreateAccount(CreateAccountDataAsync data);

}
