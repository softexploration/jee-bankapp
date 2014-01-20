package com.softexploration.lab.bankapp.ext.users.api.sync;

import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

public interface UserServiceSync {

	UserData getUser(UserId id);
}
