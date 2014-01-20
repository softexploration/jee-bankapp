package com.softexploration.lab.bankapp.ext.users.api;

import com.softexploration.lab.bankapp.ext.users.api.async.UserServiceAsync;
import com.softexploration.lab.bankapp.ext.users.api.sync.UserServiceSync;

public interface UserService extends UserServiceAsync, UserServiceSync {

}
