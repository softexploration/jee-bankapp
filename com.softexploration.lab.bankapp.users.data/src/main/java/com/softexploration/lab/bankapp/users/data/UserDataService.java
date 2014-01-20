package com.softexploration.lab.bankapp.users.data;

import java.util.List;

import com.softexploration.lab.bankapp.domain.user.dto.UserDTO;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;
import com.softexploration.lab.bankapp.ext.domain.user.update.UpdateUserData;

public interface UserDataService {

	UserDTO createUser(CreateUserData data);
	
	UserDTO getUser(UserId id);
	
	UserDTO updateUser(UpdateUserData data);
	
	UserDTO removeUser(UserId id);
	
	List<UserDTO> getAllUsers();
}
