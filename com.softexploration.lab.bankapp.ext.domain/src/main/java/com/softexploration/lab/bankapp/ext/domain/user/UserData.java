package com.softexploration.lab.bankapp.ext.domain.user;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.address.AddressData;

public interface UserData extends Serializable {

	UserId getId();

	String getName1();

	String getName2();

	AddressData getAddress1();

	AddressData getAddress2();

	UserStatus getStatus();

}
