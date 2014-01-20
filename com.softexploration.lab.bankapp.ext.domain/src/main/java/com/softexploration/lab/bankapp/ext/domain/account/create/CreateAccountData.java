package com.softexploration.lab.bankapp.ext.domain.account.create;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;

public interface CreateAccountData extends Serializable {

	AccountData getAccountData();
}
