package com.softexploration.lab.bankapp.users.service.create.process.internal.type;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public interface CreateUserFailure extends Serializable {

	AsyncResponseId getAsyncResponseId();

	Integer getCode();

	String getMessage();
}
