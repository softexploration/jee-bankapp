package com.softexploration.lab.bankapp.accounts.service.create.process.internal.type;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public interface CreateAccountFailure extends Serializable {

	AsyncResponseId getAsyncResponseId();

	Integer getCode();

	String getMessage();
}
