package com.softexploration.lab.bankapp.users.service;

import java.util.List;

import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;

public interface UserBusinessService {

	UserData createUser(CreateUserData data);

	UserData getUser(UserId id);
	
	List<UserData> getAllUsers();
}
