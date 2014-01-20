package com.softexploration.lab.bankapp.ext.domain.impl.user;

import java.util.List;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.user.UserDataProfile;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.UserStatus;

public class UserDataProfileImpl extends UserDataImpl implements UserDataProfile {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1123780466845178807L;

	private List<AccountData> accounts;

	public UserDataProfileImpl(UserId id, String name1, String name2, AddressData address1,
			AddressData address2, UserStatus status, List<AccountData> accounts) {
		super(id, name1, name2, address1, address2, status);
		this.accounts = accounts;
	}

	public List<AccountData> getAccounts() {
		return accounts;
	}

}
