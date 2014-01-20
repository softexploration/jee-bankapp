package com.softexploration.lab.bankapp.domain.impl.cmn.factory;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;
import com.softexploration.lab.bankapp.domain.account.async.CreateAccountDataAsync;
import com.softexploration.lab.bankapp.domain.account.async.impl.CreateAccountDataAsyncImpl;
import com.softexploration.lab.bankapp.domain.user.async.CreateUserDataAsync;
import com.softexploration.lab.bankapp.domain.user.async.impl.CreateUserDataAsyncImpl;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;

public class DomainObjectFactory {

	private static DomainObjectFactory instance;

	private DomainObjectFactory() {
	}

	public static DomainObjectFactory getInstance() {
		if (instance == null) {
			instance = new DomainObjectFactory();
		}
		return instance;
	}

	public CreateAccountDataAsync createCreateAccountDataAsync(AccountData data,
			AsyncResponseId asyncResponseId, OperationEntryId operationEntryId) {
		CreateAccountDataAsyncImpl ret = new CreateAccountDataAsyncImpl(data, asyncResponseId,
				operationEntryId);
		return ret;
	}

	public CreateUserDataAsync createCreateUserDataAsync(UserData userData,
			AsyncResponseId asyncResponseId, OperationEntryId operationEntryId) {
		return new CreateUserDataAsyncImpl(userData, asyncResponseId, operationEntryId);
	}
}
