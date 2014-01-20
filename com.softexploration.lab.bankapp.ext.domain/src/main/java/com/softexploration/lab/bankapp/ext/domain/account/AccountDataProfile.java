package com.softexploration.lab.bankapp.ext.domain.account;

import com.softexploration.lab.bankapp.ext.domain.user.UserData;

public interface AccountDataProfile extends AccountData {

	UserData getUser();
}
