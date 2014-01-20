package com.softexploration.lab.bankapp.users.service.create.process;

import com.softexploration.lab.bankapp.domain.user.async.CreateUserDataAsync;


public interface UserBusinessServiceAsync {

	void processCreateAccount(CreateUserDataAsync data);

}
