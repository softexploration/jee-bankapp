package com.softexploration.lab.bankapp.ext.domain.impl.user.response;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.response.CreateUserDataResponse;

public class CreateUserDataResponseImpl implements CreateUserDataResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3262497095192750833L;

	private Integer code;
	private String message;
	private UserId userId;
	private AsyncResponseId asyncResponseId;

	public CreateUserDataResponseImpl(Integer code, String message, UserId userId,
			AsyncResponseId asyncResponseId) {
		super();
		this.code = code;
		this.message = message;
		this.userId = userId;
		this.asyncResponseId = asyncResponseId;
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

	public UserId getUserId() {
		return userId;
	}

}
