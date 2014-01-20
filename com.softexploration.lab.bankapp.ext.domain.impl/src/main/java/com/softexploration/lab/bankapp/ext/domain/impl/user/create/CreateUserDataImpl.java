package com.softexploration.lab.bankapp.ext.domain.impl.user.create;

import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;

public class CreateUserDataImpl implements CreateUserData {

	private static final long serialVersionUID = 1364586491349996931L;

	private UserData userData;

	public CreateUserDataImpl(UserData userData) {
		super();
		this.userData = userData;
	}

	public UserData getUserData() {
		return userData;
	}

}
