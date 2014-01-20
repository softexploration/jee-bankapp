package com.softexploration.lab.bankapp.users.service.create.process.internal;

import javax.jms.JMSException;

import com.softexploration.lab.bankapp.users.service.create.process.internal.type.CreateUserFailure;
import com.softexploration.lab.bankapp.users.service.create.process.internal.type.CreateUserSuccess;

public interface CreateUserServiceAsync {

	void finalizeSuccess(CreateUserSuccess data) throws JMSException;

	void finalizeFailure(CreateUserFailure data) throws JMSException;
}
