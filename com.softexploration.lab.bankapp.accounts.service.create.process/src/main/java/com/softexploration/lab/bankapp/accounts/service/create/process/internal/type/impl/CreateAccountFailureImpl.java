package com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.impl;

import com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.CreateAccountFailure;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public class CreateAccountFailureImpl implements CreateAccountFailure {

	private static final long serialVersionUID = -6254343623743209754L;

	private AsyncResponseId asyncResponseId;
	private Integer code;
	private String message;

	public CreateAccountFailureImpl(AsyncResponseId asyncResponseId, Integer code, String message) {
		super();
		this.asyncResponseId = asyncResponseId;
		this.code = code;
		this.message = message;
	}

	public AsyncResponseId getAsyncResponseId() {
		return asyncResponseId;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
