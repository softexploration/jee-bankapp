package com.softexploration.lab.bankapp.users.service.create.process.internal.type.impl;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.users.service.create.process.internal.type.CreateUserSuccess;

public class CreateUserSuccessImpl implements CreateUserSuccess {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AsyncResponseId asyncResponseId;
	private com.softexploration.lab.bankapp.ext.domain.user.UserData userData;

	public CreateUserSuccessImpl(AsyncResponseId asyncResponseId,
			com.softexploration.lab.bankapp.ext.domain.user.UserData userData) {
		super();
		this.asyncResponseId = asyncResponseId;
		this.userData = userData;
	}

	public AsyncResponseId getAsyncResponseId() {
		return asyncResponseId;
	}

	public com.softexploration.lab.bankapp.ext.domain.user.UserData getUserData() {
		return userData;
	}

}
