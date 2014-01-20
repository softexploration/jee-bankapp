package com.softexploration.lab.bankapp.ext.domain.impl.account.factory;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.AccountDataProfile;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.AccountStatus;
import com.softexploration.lab.bankapp.ext.domain.account.AccountType;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.account.request.CreateAccountDataRequest;
import com.softexploration.lab.bankapp.ext.domain.account.response.CreateAccountDataAcceptedRequestResponse;
import com.softexploration.lab.bankapp.ext.domain.account.response.CreateAccountDataResponse;
import com.softexploration.lab.bankapp.ext.domain.account.update.UpdateAccountData;
import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.address.AddressId;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncRequestId;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.impl.account.AccountDataImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.account.AccountDataProfileImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.account.AccountIdImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.account.create.CreateAccountDataImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.account.request.CreateAccountDataRequestImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.account.response.CreateAccountDataAcceptedRequestResponseImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.account.response.CreateAccountDataResponseImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.account.update.UpdateAccountDataImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.address.AddressDataImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.address.AddressIdImpl;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

public class AccountExtDomainObjectFactory {

	private static AccountExtDomainObjectFactory instance;

	private AccountExtDomainObjectFactory() {
	}

	public static AccountExtDomainObjectFactory getInstance() {
		if (instance == null) {
			instance = new AccountExtDomainObjectFactory();
		}
		return instance;
	}

	public AccountData createAccountData(AccountId id, String name1, AccountType accountType,
			AccountStatus accountStatus, UserId userId) {
		return new AccountDataImpl(id, name1, accountType, accountStatus, userId);
	}

	public AccountId createAccountId(String number) {
		return new AccountIdImpl(number);
	}

	public CreateAccountData createCreateAccountData(AccountData accountData) {
		return new CreateAccountDataImpl(accountData);
	}

	public UpdateAccountData createUpdateAccountData() {
		return new UpdateAccountDataImpl();
	}

	public CreateAccountDataRequest createCreateAccountDataRequest(AsyncRequestId asyncRequestId,
			AccountData accountData) {
		return new CreateAccountDataRequestImpl(asyncRequestId, accountData);
	}

	public CreateAccountDataAcceptedRequestResponse createCreateAccountDataResponse(
			AsyncResponseId asyncResponseId) {
		return new CreateAccountDataAcceptedRequestResponseImpl(asyncResponseId);
	}

	public CreateAccountDataResponse createCreateAccountDataResponse(Integer code, String msg,
			AccountId accountId, AsyncResponseId asyncResponseId) {
		return new CreateAccountDataResponseImpl(code, msg, accountId, asyncResponseId);
	}

	public AddressData createAddressData(AddressId id, String region, String country, String city,
			String zip, String street) {
		return new AddressDataImpl(id, region, country, city, zip, street);
	}

	public AddressId createAddressId(Long id) {
		return new AddressIdImpl(id);
	}

	public AccountDataProfile createAccountDataProfile(AccountId id, String name1,
			AccountType accountType, AccountStatus accountStatus, UserId userId, UserData user) {
		return new AccountDataProfileImpl(id, name1, accountType, accountStatus, userId, user);
	}
}
