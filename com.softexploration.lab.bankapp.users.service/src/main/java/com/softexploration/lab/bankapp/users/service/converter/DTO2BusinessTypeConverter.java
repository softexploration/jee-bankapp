package com.softexploration.lab.bankapp.users.service.converter;

import java.util.List;

import com.softexploration.lab.bankapp.domain.user.dto.UserDTO;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;

public interface DTO2BusinessTypeConverter {

	UserData convert(UserDTO dto);

	List<UserData> convert(List<UserDTO> list);
}
