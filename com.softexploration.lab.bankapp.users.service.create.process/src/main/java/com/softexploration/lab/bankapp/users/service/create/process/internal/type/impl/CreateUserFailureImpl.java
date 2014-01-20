package com.softexploration.lab.bankapp.users.service.create.process.internal.type.impl;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.users.service.create.process.internal.type.CreateUserFailure;

public class CreateUserFailureImpl implements CreateUserFailure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AsyncResponseId asyncResponseId;
	private Integer code;
	private String message;

	public CreateUserFailureImpl(AsyncResponseId asyncResponseId, Integer code, String message) {
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
