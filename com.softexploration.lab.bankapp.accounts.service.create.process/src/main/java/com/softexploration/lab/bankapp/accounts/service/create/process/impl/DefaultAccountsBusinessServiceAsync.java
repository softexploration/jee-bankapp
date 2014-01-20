package com.softexploration.lab.bankapp.accounts.service.create.process.impl;

import java.util.Random;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
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

import com.softexploration.lab.bankapp.accounts.service.create.process.AccountsBusinessServiceAsync;
import com.softexploration.lab.bankapp.domain.account.async.CreateAccountDataAsync;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DefaultAccountsBusinessServiceAsync implements AccountsBusinessServiceAsync {

	@Resource(mappedName = "jms/BankappConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "jms/createAccountRequestQueue")
	private Destination createAccountRequestQueue;

	@Resource
	SessionContext ctx;

	public void processCreateAccount(CreateAccountDataAsync data) {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(createAccountRequestQueue);
			ObjectMessage message = session.createObjectMessage(data);
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
