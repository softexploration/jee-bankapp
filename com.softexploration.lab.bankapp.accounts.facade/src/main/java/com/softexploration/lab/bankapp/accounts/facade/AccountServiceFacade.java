package com.softexploration.lab.bankapp.accounts.facade;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationRegisterService;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationStatus;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationType;
import com.softexploration.lab.bankapp.accounts.oper.reqister.factory.OperationRegisterObjectFactory;
import com.softexploration.lab.bankapp.accounts.service.AccountBusinessService;
import com.softexploration.lab.bankapp.accounts.service.create.process.AccountsBusinessServiceAsync;
import com.softexploration.lab.bankapp.domain.account.async.CreateAccountDataAsync;
import com.softexploration.lab.bankapp.domain.impl.cmn.factory.DomainObjectFactory;
import com.softexploration.lab.bankapp.ext.accounts.api.AccountService;
import com.softexploration.lab.bankapp.ext.accounts.api.AccountServiceLocal;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.request.CreateAccountDataRequest;
import com.softexploration.lab.bankapp.ext.domain.account.response.CreateAccountDataAcceptedRequestResponse;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.impl.account.factory.AccountExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.impl.cmn.factory.CmnDomainObjectFactory;

import org.apache.log4j.Logger;

@Stateless
public class AccountServiceFacade implements AccountService, AccountServiceLocal {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(AccountServiceFacade.class);

	@EJB
	private AccountBusinessService accountsBusinessService;

	@EJB
	private AccountsBusinessServiceAsync accountsBusinessServiceAsync;

	@EJB
	private OperationRegisterService operationRegisterService;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public AccountData getAccount(AccountId id) {
		return accountsBusinessService.getAccount(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CreateAccountDataAcceptedRequestResponse createAccount(CreateAccountDataRequest request) {

		Long externalRequestId = request.getAsyncRequestId().getExternalRequestId();
		Long internalRequestId = operationRegisterService.generateInternalRequestId();
		AsyncResponseId asyncResponseId = CmnDomainObjectFactory.getInstance()
				.createAsyncResponseId(internalRequestId, externalRequestId);

		OperationEntry operationEntry = OperationRegisterObjectFactory.getInstance()
				.createOperationEntry(null, OperationType.C, OperationStatus.A, internalRequestId,
						externalRequestId, new Date());
		OperationEntry createdOperationEntry = operationRegisterService.reqister(operationEntry);

		CreateAccountDataAsync createAccountDataAsync = DomainObjectFactory.getInstance()
				.createCreateAccountDataAsync(request.getAccountData(), asyncResponseId,
						createdOperationEntry.getId());

		accountsBusinessServiceAsync.processCreateAccount(createAccountDataAsync);

		return AccountExtDomainObjectFactory.getInstance().createCreateAccountDataResponse(
				asyncResponseId);
	}

}
