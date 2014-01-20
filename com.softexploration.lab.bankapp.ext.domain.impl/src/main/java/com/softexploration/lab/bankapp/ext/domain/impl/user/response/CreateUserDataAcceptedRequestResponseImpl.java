package com.softexploration.lab.bankapp.ext.domain.impl.user.response;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.user.response.CreateUserDataAcceptedRequestResponse;

public class CreateUserDataAcceptedRequestResponseImpl implements
		CreateUserDataAcceptedRequestResponse {

	private static final long serialVersionUID = -4329644637761166327L;

	private AsyncResponseId asyncResponseId;

	public CreateUserDataAcceptedRequestResponseImpl(AsyncResponseId asyncResponseId) {
		super();
		this.asyncResponseId = asyncResponseId;
	}

	public AsyncResponseId getAsyncResponseId() {
		return asyncResponseId;
	}

}
