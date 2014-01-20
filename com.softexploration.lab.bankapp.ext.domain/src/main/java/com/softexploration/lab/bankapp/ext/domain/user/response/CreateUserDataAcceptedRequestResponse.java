package com.softexploration.lab.bankapp.ext.domain.user.response;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public interface CreateUserDataAcceptedRequestResponse extends Serializable {

	AsyncResponseId getAsyncResponseId();
}
