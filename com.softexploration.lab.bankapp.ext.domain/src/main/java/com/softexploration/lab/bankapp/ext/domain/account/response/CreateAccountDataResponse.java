package com.softexploration.lab.bankapp.ext.domain.account.response;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public interface CreateAccountDataResponse extends Serializable {

	AsyncResponseId getAsyncResponseId();

	Integer getCode();

	String getMessage();

	AccountId getAccountId();

}
