package com.softexploration.lab.bankapp.users.service.converter.impl;

import java.util.ArrayList;
import java.util.List;

import com.softexploration.lab.bankapp.domain.user.dto.UserDTO;
import com.softexploration.lab.bankapp.ext.domain.impl.user.factory.UserExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.users.service.converter.DTO2BusinessTypeConverter;

public class DefaultDTO2BusinessTypeConverter implements DTO2BusinessTypeConverter {

	public UserData convert(UserDTO dto) {
		return UserExtDomainObjectFactory.getInstance().createUserData(dto.getId(), dto.getName1(),
				dto.getName2(), dto.getAddress1(), dto.getAddress2(), dto.getStatus());
	}

	public List<UserData> convert(List<UserDTO> list) {
		List<UserData> ret = new ArrayList<UserData>();
		for (UserDTO dto : list) {
			UserData userData = UserExtDomainObjectFactory.getInstance().createUserData(
					dto.getId(), dto.getName1(), dto.getName2(), dto.getAddress1(),
					dto.getAddress2(), dto.getStatus());
			ret.add(userData);
		}
		return ret;
	}

}
