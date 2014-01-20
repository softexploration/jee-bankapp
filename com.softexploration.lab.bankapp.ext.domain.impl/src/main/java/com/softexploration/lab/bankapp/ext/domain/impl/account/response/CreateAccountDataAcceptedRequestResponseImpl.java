package com.softexploration.lab.bankapp.ext.domain.impl.account.response;

import com.softexploration.lab.bankapp.ext.domain.account.response.CreateAccountDataAcceptedRequestResponse;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public class CreateAccountDataAcceptedRequestResponseImpl implements
		CreateAccountDataAcceptedRequestResponse {

	private static final long serialVersionUID = -4329644637761166327L;

	private AsyncResponseId asyncResponseId;

	public CreateAccountDataAcceptedRequestResponseImpl(AsyncResponseId asyncResponseId) {
		super();
		this.asyncResponseId = asyncResponseId;
	}

	public AsyncResponseId getAsyncResponseId() {
		return asyncResponseId;
	}

}
