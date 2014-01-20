package com.softexploration.lab.bankapp.accounts.service.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.softexploration.lab.bankapp.accounts.service.validator.CreateAccountValidator;
import com.softexploration.lab.bankapp.accounts.service.validator.impl.CreateAccountValidatorImpl;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;

public class CreateAccountValidationInterceptor {

	private CreateAccountValidator validator = new CreateAccountValidatorImpl();

	@AroundInvoke
	public Object createAccount(InvocationContext ctx) throws Exception {
		Object[] parameters = ctx.getParameters();
		CreateAccountData data = (CreateAccountData) parameters[0];
		validator.validate(data);
		return ctx.proceed();
	}
}
