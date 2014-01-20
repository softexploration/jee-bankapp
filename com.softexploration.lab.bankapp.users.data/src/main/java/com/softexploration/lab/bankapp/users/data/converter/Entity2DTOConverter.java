package com.softexploration.lab.bankapp.users.data.converter;

import com.softexploration.lab.bankapp.domain.user.dto.UserDTO;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;
import com.softexploration.lab.bankapp.users.data.entities.Address;
import com.softexploration.lab.bankapp.users.data.entities.User;

public interface Entity2DTOConverter {

	UserDTO convert(User entity, Address address1, Address address2);

	void convert(CreateUserData source, User dest);
}
