package com.softexploration.lab.bankapp.users.service.create.process.impl;

import javax.annotation.Resource;
import javax.ejb.Local;
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

import com.softexploration.lab.bankapp.domain.user.async.CreateUserDataAsync;
import com.softexploration.lab.bankapp.users.service.create.process.UserBusinessServiceAsync;

@Stateless
@Local(UserBusinessServiceAsync.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DefaultUserBusinessServiceAsync implements UserBusinessServiceAsync {

	@Resource(mappedName = "jms/BankappConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "jms/createUserRequestQueue")
	private Destination createUserRequestDestination;

	public void processCreateAccount(CreateUserDataAsync data) {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(createUserRequestDestination);
			ObjectMessage message = session.createObjectMessage(data);
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
