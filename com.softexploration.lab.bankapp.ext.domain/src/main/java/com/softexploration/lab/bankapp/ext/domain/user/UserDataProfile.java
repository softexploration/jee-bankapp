package com.softexploration.lab.bankapp.ext.domain.user;

import java.util.List;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;

public interface UserDataProfile extends UserData {

	List<AccountData> getAccounts();
}
