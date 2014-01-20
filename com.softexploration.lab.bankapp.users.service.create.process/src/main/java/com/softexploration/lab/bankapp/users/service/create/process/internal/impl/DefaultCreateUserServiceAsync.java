package com.softexploration.lab.bankapp.users.service.create.process.internal.impl;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.softexploration.lab.bankapp.users.service.create.process.internal.type.CreateUserFailure;
import com.softexploration.lab.bankapp.users.service.create.process.internal.type.CreateUserSuccess;
import com.softexploration.lab.bankapp.users.service.create.process.internal.CreateUserServiceAsync;

@Stateless
@Local(CreateUserServiceAsync.class)
public class DefaultCreateUserServiceAsync implements CreateUserServiceAsync {

	@Resource(mappedName = "jms/BankappConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "jms/createUserFinalizeSuccessQueue")
	private Destination createUserFinalizeSuccessDestination;

	@Resource(mappedName = "jms/createUserFinalizeFailureQueue")
	private Destination createUserFinalizeFailureDestination;

	public void finalizeSuccess(CreateUserSuccess data) throws JMSException {
		send(createUserFinalizeSuccessDestination, data);
	}

	public void finalizeFailure(CreateUserFailure data) throws JMSException {
		send(createUserFinalizeFailureDestination, data);
	}

	protected void send(Destination destination, Serializable data) throws JMSException {
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(destination);
		ObjectMessage message = session.createObjectMessage(data);
		producer.send(message);
	}
}
