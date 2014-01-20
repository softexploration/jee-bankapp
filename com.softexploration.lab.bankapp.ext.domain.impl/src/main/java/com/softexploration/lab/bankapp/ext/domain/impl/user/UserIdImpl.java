package com.softexploration.lab.bankapp.ext.domain.impl.user;

import com.softexploration.lab.bankapp.ext.domain.user.UserId;

public class UserIdImpl implements UserId {

	private static final long serialVersionUID = -3616870764753859605L;

	private Long id;

	public UserIdImpl(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
