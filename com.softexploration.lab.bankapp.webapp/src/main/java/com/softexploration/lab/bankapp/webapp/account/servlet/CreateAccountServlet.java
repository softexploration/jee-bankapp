package com.softexploration.lab.bankapp.webapp.account.servlet;

import java.io.IOException;
import java.util.Random;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softexploration.lab.bankapp.ext.accounts.api.AccountServiceLocal;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.AccountStatus;
import com.softexploration.lab.bankapp.ext.domain.account.AccountType;
import com.softexploration.lab.bankapp.ext.domain.account.request.CreateAccountDataRequest;
import com.softexploration.lab.bankapp.ext.domain.account.response.CreateAccountDataAcceptedRequestResponse;
import com.softexploration.lab.bankapp.ext.domain.impl.account.factory.AccountExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.impl.cmn.factory.CmnDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.impl.user.factory.UserExtDomainObjectFactory;

public class CreateAccountServlet extends HttpServlet {

	private static final long serialVersionUID = -6235434713450090995L;

	@EJB
	private AccountServiceLocal accountService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// externalRequestId
		Long externalRequestId = new Random().nextLong();

		// accountData
		AccountData accountData = null;
		try {
			accountData = prepareAccountData(request);
			validate(accountData);
		} catch (Exception ex) {
			response.getWriter().println(ex.getMessage());
			return;
		}

		// createAccountDataRequest
		CreateAccountDataRequest createAccountDataRequest = AccountExtDomainObjectFactory
				.getInstance().createCreateAccountDataRequest(
						CmnDomainObjectFactory.getInstance()
								.createAsyncRequestId(externalRequestId), accountData);

		CreateAccountDataAcceptedRequestResponse createAccount = accountService
				.createAccount(createAccountDataRequest);

		response.getWriter().println(
				"request sent [" + createAccount.getAsyncResponseId().getExternalRequestId()
						+ "] jobId [" + createAccount.getAsyncResponseId().getInternalRequestId()
						+ "]");
	}

	private AccountData prepareAccountData(HttpServletRequest request) {
		String number = request.getParameter("number");
		String name1 = request.getParameter("name1");
		String accountType = request.getParameter("accountType");
		String accountStatus = request.getParameter("accountStatus");
		String userId = request.getParameter("userId");

		AccountData accountData = AccountExtDomainObjectFactory.getInstance().createAccountData(
				AccountExtDomainObjectFactory.getInstance().createAccountId(number), name1,
				provideDefault(convertAccountType(accountType), AccountType.A),
				provideDefault(convertAccountStatus(accountStatus), AccountStatus.A),
				UserExtDomainObjectFactory.getInstance().createUserId(convertUserId(userId)));

		return accountData;
	}

	private void validate(AccountData data) {
		if (data.getId() == null) {
			throw new IllegalArgumentException("number is not set");
		}
		if (data.getUserId() == null) {
			throw new IllegalArgumentException("user is not set");
		}
	}

	private AccountType convertAccountType(String value) {
		if (value != null) {
			return AccountType.valueOf(value);
		} else {
			return null;
		}
	}

	private AccountStatus convertAccountStatus(String value) {
		if (value != null) {
			return AccountStatus.valueOf(value);
		} else {
			return null;
		}
	}

	private Long convertUserId(String value) {
		if (value != null) {
			return Long.valueOf(value);
		} else {
			return null;
		}
	}

	private <T> T provideDefault(T value, T defaultValue) {
		return value != null ? value : defaultValue;
	}

}
