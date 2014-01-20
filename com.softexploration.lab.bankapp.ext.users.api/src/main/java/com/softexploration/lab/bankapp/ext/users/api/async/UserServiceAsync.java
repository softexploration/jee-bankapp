package com.softexploration.lab.bankapp.ext.users.api.async;

import com.softexploration.lab.bankapp.ext.domain.user.request.CreateUserDataRequest;
import com.softexploration.lab.bankapp.ext.domain.user.response.CreateUserDataAcceptedRequestResponse;

public interface UserServiceAsync {

	CreateUserDataAcceptedRequestResponse createUser(CreateUserDataRequest request);
}
