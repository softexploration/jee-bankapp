package com.softexploration.lab.bankapp.ext.domain.impl.user.resquest;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncRequestId;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.request.CreateUserDataRequest;

public class CreateUserDataRequestImpl implements CreateUserDataRequest {

	private static final long serialVersionUID = -4394302856385609846L;

	private AsyncRequestId asyncRequestId;
	private UserData userData;

	public CreateUserDataRequestImpl(AsyncRequestId asyncRequestId, UserData userData) {
		super();
		this.asyncRequestId = asyncRequestId;
		this.userData = userData;
	}

	public UserData getUserData() {
		return userData;
	}

	public AsyncRequestId getAsyncRequestId() {
		return asyncRequestId;
	}

}
