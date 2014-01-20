package com.softexploration.lab.bankapp.ext.domain.user.request;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncRequestId;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;

public interface CreateUserDataRequest extends CreateUserData {

	AsyncRequestId getAsyncRequestId();
}
