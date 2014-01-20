package com.softexploration.lab.bankapp.ext.domain.impl.account;

import com.softexploration.lab.bankapp.ext.domain.account.AccountDataProfile;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.AccountStatus;
import com.softexploration.lab.bankapp.ext.domain.account.AccountType;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

public class AccountDataProfileImpl extends AccountDataImpl implements AccountDataProfile {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4181084494705724545L;

	private UserData user;

	public AccountDataProfileImpl(AccountId id, String name1, AccountType accountType,
			AccountStatus accountStatus, UserId userId, UserData user) {
		super(id, name1, accountType, accountStatus, userId);
		this.user = user;
	}

	public UserData getUser() {
		return user;
	}

}
