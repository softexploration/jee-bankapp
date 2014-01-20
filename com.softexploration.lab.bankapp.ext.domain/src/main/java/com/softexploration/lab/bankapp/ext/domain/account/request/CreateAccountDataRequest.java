package com.softexploration.lab.bankapp.ext.domain.account.request;

import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncRequestId;

public interface CreateAccountDataRequest extends CreateAccountData {

	AsyncRequestId getAsyncRequestId();
}
