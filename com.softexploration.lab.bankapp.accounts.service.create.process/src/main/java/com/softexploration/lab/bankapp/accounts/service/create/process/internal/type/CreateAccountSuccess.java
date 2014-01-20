package com.softexploration.lab.bankapp.accounts.service.create.process.internal.type;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public interface CreateAccountSuccess extends Serializable {

	AsyncResponseId getAsyncResponseId();

	AccountData getAccountData();
}
