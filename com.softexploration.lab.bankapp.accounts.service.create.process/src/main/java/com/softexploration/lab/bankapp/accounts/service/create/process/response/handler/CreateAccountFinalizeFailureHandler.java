package com.softexploration.lab.bankapp.accounts.service.create.process.response.handler;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.CreateAccountFailure;
import com.softexploration.lab.bankapp.ext.domain.account.response.CreateAccountDataResponse;
import com.softexploration.lab.bankapp.ext.domain.impl.account.factory.AccountExtDomainObjectFactory;

import org.apache.log4j.Logger;

@MessageDriven(messageListenerInterface = MessageListener.class, mappedName = "jms/createAccountFinalizeFailureQueue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CreateAccountFinalizeFailureHandler {

	private static final Logger LOG = Logger.getLogger(CreateAccountFinalizeSuccessHandler.class);

	@Resource(mappedName = "jms/BankappConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "jms/createAccountResponseQueue")
	private Destination createAccountResponseQueue;

	public void onMessage(Message message) {
		System.out.println("CreateAccountFinalizeFailureHandler");
		if (message instanceof ObjectMessage) {
			try {
				Serializable object = ((ObjectMessage) message).getObject();
				if (object instanceof CreateAccountFailure) {
					CreateAccountFailure data = (CreateAccountFailure) object;
					CreateAccountDataResponse response = AccountExtDomainObjectFactory.getInstance()
							.createCreateAccountDataResponse(data.getCode(), data.getMessage(),
									null, data.getAsyncResponseId());
					send(response);
				} else {
					LOG.warn("object is type of: " + object.getClass().getCanonicalName());
				}
			} catch (Throwable e) {
				LOG.error(e.getMessage(), e);
			}
		} else {
			LOG.warn("message is type of: " + message.getClass().getCanonicalName());
		}
	}

	protected void send(Serializable data) throws JMSException {
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(createAccountResponseQueue);
		ObjectMessage message = session.createObjectMessage(data);
		producer.send(message);
	}
}
