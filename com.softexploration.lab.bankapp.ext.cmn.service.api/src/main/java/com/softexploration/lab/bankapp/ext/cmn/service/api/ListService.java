package com.softexploration.lab.bankapp.ext.cmn.service.api;

import java.util.List;

import com.softexploration.lab.bankapp.ext.domain.account.AccountDataProfile;
import com.softexploration.lab.bankapp.ext.domain.user.UserDataProfile;

public interface ListService {

	List<UserDataProfile> getAllUsers();

	List<AccountDataProfile> getAllAccounts();
}
