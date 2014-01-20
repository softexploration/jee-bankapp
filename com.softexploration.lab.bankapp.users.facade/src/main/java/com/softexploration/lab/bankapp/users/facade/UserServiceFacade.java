package com.softexploration.lab.bankapp.users.facade;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationRegisterService;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationStatus;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationType;
import com.softexploration.lab.bankapp.accounts.oper.reqister.factory.OperationRegisterObjectFactory;
import com.softexploration.lab.bankapp.domain.impl.cmn.factory.DomainObjectFactory;
import com.softexploration.lab.bankapp.domain.user.async.CreateUserDataAsync;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.impl.cmn.factory.CmnDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.impl.user.factory.UserExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.request.CreateUserDataRequest;
import com.softexploration.lab.bankapp.ext.domain.user.response.CreateUserDataAcceptedRequestResponse;
import com.softexploration.lab.bankapp.ext.users.api.UserService;
import com.softexploration.lab.bankapp.ext.users.api.UserServiceLocal;
import com.softexploration.lab.bankapp.users.service.UserBusinessService;
import com.softexploration.lab.bankapp.users.service.create.process.UserBusinessServiceAsync;


@Stateless
@Local(UserServiceLocal.class)
@Remote(UserService.class)
public class UserServiceFacade implements UserServiceLocal {

	@EJB(beanName = "defaultUserBusinessService")
	private UserBusinessService userBusinessService;

	@EJB
	private UserBusinessServiceAsync userBusinessServiceAsync;

	@EJB
	private OperationRegisterService operationRegisterService;

	public CreateUserDataAcceptedRequestResponse createUser(CreateUserDataRequest request) {

		Long externalRequestId = request.getAsyncRequestId().getExternalRequestId();
		Long internalRequestId = operationRegisterService.generateInternalRequestId();
		AsyncResponseId asyncResponseId = CmnDomainObjectFactory.getInstance()
				.createAsyncResponseId(internalRequestId, externalRequestId);

		OperationEntry operationEntry = OperationRegisterObjectFactory.getInstance()
				.createOperationEntry(null, OperationType.C, OperationStatus.A, internalRequestId,
						externalRequestId, new Date());
		OperationEntry createdOperationEntry = operationRegisterService.reqister(operationEntry);

		CreateUserDataAsync createUserDataAsync = DomainObjectFactory.getInstance()
				.createCreateUserDataAsync(request.getUserData(), asyncResponseId,
						createdOperationEntry.getId());

		userBusinessServiceAsync.processCreateAccount(createUserDataAsync);

		return UserExtDomainObjectFactory.getInstance()
				.createCreateUserDataAcceptedRequestResponse(asyncResponseId);
	}

	public UserData getUser(UserId id) {
		return userBusinessService.getUser(id);
	}

}
