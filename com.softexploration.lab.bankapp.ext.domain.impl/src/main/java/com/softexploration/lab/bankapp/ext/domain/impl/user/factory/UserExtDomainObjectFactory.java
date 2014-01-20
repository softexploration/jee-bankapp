package com.softexploration.lab.bankapp.ext.domain.impl.user.factory;

import java.util.List;

import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncRequestId;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.impl.user.UserDataImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.user.UserDataProfileImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.user.UserIdImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.user.create.CreateUserDataImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.user.response.CreateUserDataAcceptedRequestResponseImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.user.response.CreateUserDataResponseImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.user.resquest.CreateUserDataRequestImpl;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserDataProfile;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.UserStatus;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;
import com.softexploration.lab.bankapp.ext.domain.user.request.CreateUserDataRequest;
import com.softexploration.lab.bankapp.ext.domain.user.response.CreateUserDataAcceptedRequestResponse;
import com.softexploration.lab.bankapp.ext.domain.user.response.CreateUserDataResponse;

public class UserExtDomainObjectFactory {

	private static UserExtDomainObjectFactory instance;

	private UserExtDomainObjectFactory() {
	}

	public static UserExtDomainObjectFactory getInstance() {
		if (instance == null) {
			instance = new UserExtDomainObjectFactory();
		}
		return instance;
	}

	public UserId createUserId(Long id) {
		return new UserIdImpl(id);
	}

	public UserData createUserData(UserId id, String name1, String name2, AddressData address1,
			AddressData address2, UserStatus status) {
		return new UserDataImpl(id, name1, name2, address1, address2, status);
	}

	public CreateUserData createCreateUserData(UserData userData) {
		return new CreateUserDataImpl(userData);
	}

	public CreateUserDataRequest createCreateUserDataRequest(AsyncRequestId asyncRequestId,
			UserData userData) {
		return new CreateUserDataRequestImpl(asyncRequestId, userData);
	}

	public CreateUserDataResponse createCreateUserDataResponse(Integer code, String message,
			UserId userId, AsyncResponseId asyncResponseId) {
		return new CreateUserDataResponseImpl(code, message, userId, asyncResponseId);
	}

	public CreateUserDataAcceptedRequestResponse createCreateUserDataAcceptedRequestResponse(
			AsyncResponseId asyncResponseId) {
		return new CreateUserDataAcceptedRequestResponseImpl(asyncResponseId);
	}

	public UserDataProfile createUserDataProfile(UserId id, String name1, String name2,
			AddressData address1, AddressData address2, UserStatus status,
			List<AccountData> accounts) {
		return new UserDataProfileImpl(id, name1, name2, address1, address2, status, accounts);
	}
}
