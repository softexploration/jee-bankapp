package com.softexploration.lab.bankapp.domain.user.dto;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.UserStatus;

public interface UserDTO extends Serializable {

	UserId getId();

	String getName1();

	String getName2();

	AddressData getAddress1();

	AddressData getAddress2();

	UserStatus getStatus();
}
