package com.softexploration.lab.bankapp.ext.accounts.api.async;

import com.softexploration.lab.bankapp.ext.domain.account.request.CreateAccountDataRequest;
import com.softexploration.lab.bankapp.ext.domain.account.response.CreateAccountDataAcceptedRequestResponse;

public interface AccountServiceAsync {

	CreateAccountDataAcceptedRequestResponse createAccount(CreateAccountDataRequest request);
}
