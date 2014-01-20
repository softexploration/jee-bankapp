package com.softexploration.lab.bankapp.accounts.service.create.process.internal.impl;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationRegisterService;
import com.softexploration.lab.bankapp.accounts.service.create.process.internal.CreateAccountServiceAsync;
import com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.CreateAccountFailure;
import com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.CreateAccountSuccess;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CreateAccountServiceAsyncImpl implements CreateAccountServiceAsync {

	@Resource(mappedName = "jms/BankappConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "jms/createAccountFinalizeSuccessQueue")
	private Destination createAccountFinalizeSuccessQueue;

	@Resource(mappedName = "jms/createAccountFinalizeFailureQueue")
	private Destination createAccountFinalizeFailureQueue;

	@EJB
	private OperationRegisterService operationRegisterService;

	public void finalizeSuccess(CreateAccountSuccess data) throws JMSException {
		send(createAccountFinalizeSuccessQueue, data);
	}

	public void finalizeFailure(CreateAccountFailure data) throws JMSException {
		send(createAccountFinalizeFailureQueue, data);
	}

	protected void send(Destination destination, Serializable data) throws JMSException {
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(destination);
		ObjectMessage message = session.createObjectMessage(data);
		producer.send(message);
	}

}
