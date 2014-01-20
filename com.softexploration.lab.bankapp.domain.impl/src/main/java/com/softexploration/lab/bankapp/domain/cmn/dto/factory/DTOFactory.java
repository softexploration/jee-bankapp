package com.softexploration.lab.bankapp.domain.cmn.dto.factory;

import com.softexploration.lab.bankapp.domain.account.dto.AccountDTO;
import com.softexploration.lab.bankapp.domain.account.dto.impl.AccountDTOImpl;
import com.softexploration.lab.bankapp.domain.user.dto.UserDTO;
import com.softexploration.lab.bankapp.domain.user.dto.impl.UserDTOImpl;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.AccountStatus;
import com.softexploration.lab.bankapp.ext.domain.account.AccountType;
import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.UserStatus;

public class DTOFactory {

	private static DTOFactory instance;

	private DTOFactory() {
	}

	public static DTOFactory getInstance() {
		if (instance == null) {
			instance = new DTOFactory();
		}
		return instance;
	}

	public AccountDTO createAccountDTO(AccountId id, String name1, AccountType accountType,
			AccountStatus accountStatus, UserId userId) {
		AccountDTOImpl ret = new AccountDTOImpl(id, name1, accountType, accountStatus, userId);
		return ret;
	}

	public UserDTO createUserDTO(UserId id, String name1, String name2, AddressData address1,
			AddressData address2, UserStatus status) {
		return new UserDTOImpl(id, name1, name2, address1, address2, status);
	}
}
