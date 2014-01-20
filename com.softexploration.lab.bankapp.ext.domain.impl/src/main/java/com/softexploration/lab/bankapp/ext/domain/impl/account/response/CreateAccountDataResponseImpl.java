package com.softexploration.lab.bankapp.ext.domain.impl.account.response;

import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.response.CreateAccountDataResponse;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public class CreateAccountDataResponseImpl implements CreateAccountDataResponse {

	private static final long serialVersionUID = -3617097011078056923L;

	private Integer code;
	private String message;
	private AccountId accountId;
	private AsyncResponseId asyncResponseId;

	public CreateAccountDataResponseImpl(Integer code, String message, AccountId accountId,
			AsyncResponseId asyncResponseId) {
		super();
		this.code = code;
		this.message = message;
		this.accountId = accountId;
		this.asyncResponseId = asyncResponseId;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public AccountId getAccountId() {
		return accountId;
	}

	public AsyncResponseId getAsyncResponseId() {
		return asyncResponseId;
	}

}
