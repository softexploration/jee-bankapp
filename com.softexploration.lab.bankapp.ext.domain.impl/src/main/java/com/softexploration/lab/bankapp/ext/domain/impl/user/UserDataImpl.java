package com.softexploration.lab.bankapp.ext.domain.impl.user;

import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.UserStatus;

public class UserDataImpl implements UserData {

	private static final long serialVersionUID = -2545694222982950712L;

	private UserId id;
	private String name1;
	private String name2;
	private AddressData address1;
	private AddressData address2;
	private UserStatus status;

	public UserDataImpl(UserId id, String name1, String name2, AddressData address1,
			AddressData address2, UserStatus status) {
		super();
		this.id = id;
		this.name1 = name1;
		this.name2 = name2;
		this.address1 = address1;
		this.address2 = address2;
		this.status = status;
	}

	public UserId getId() {
		return id;
	}

	public String getName1() {
		return name1;
	}

	public String getName2() {
		return name2;
	}

	public AddressData getAddress1() {
		return address1;
	}

	public AddressData getAddress2() {
		return address2;
	}

	public UserStatus getStatus() {
		return status;
	}

}
