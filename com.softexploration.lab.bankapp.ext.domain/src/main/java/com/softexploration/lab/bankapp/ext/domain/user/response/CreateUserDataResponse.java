package com.softexploration.lab.bankapp.ext.domain.user.response;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

public interface CreateUserDataResponse extends Serializable {

	AsyncResponseId getAsyncResponseId();

	Integer getCode();

	String getMessage();

	UserId getUserId();

}
