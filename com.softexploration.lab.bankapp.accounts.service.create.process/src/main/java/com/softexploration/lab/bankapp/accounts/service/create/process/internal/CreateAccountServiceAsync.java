package com.softexploration.lab.bankapp.accounts.service.create.process.internal;

import javax.ejb.Local;
import javax.jms.JMSException;

import com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.CreateAccountFailure;
import com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.CreateAccountSuccess;

@Local
public interface CreateAccountServiceAsync {

	void finalizeSuccess(CreateAccountSuccess data) throws JMSException;

	void finalizeFailure(CreateAccountFailure data) throws JMSException;
}
