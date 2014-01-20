package com.softexploration.lab.bankapp.accounts.service.create.process.request.handler;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.softexploration.lab.bankapp.accounts.service.create.process.internal.CreateAccountServiceAsync;
import com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.impl.CreateAccountFailureImpl;
import com.softexploration.lab.bankapp.accounts.service.create.process.internal.type.impl.CreateAccountSuccessImpl;
import com.softexploration.lab.bankapp.accounts.service.create.process.proxy.AccountBusinessServiceProxy;
import com.softexploration.lab.bankapp.domain.account.async.CreateAccountDataAsync;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;

import org.apache.log4j.Logger;

@MessageDriven(mappedName = "jms/createAccountRequestQueue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class CreateAccountRequestHandler implements MessageListener {

	private static final Logger LOG = Logger.getLogger(CreateAccountRequestHandler.class);

	@EJB
	private AccountBusinessServiceProxy accountBusinessServiceProxy;

	@EJB
	private CreateAccountServiceAsync createAccountServiceAsync;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void onMessage(Message message) {

		if (message instanceof ObjectMessage) {
			CreateAccountDataAsync data = null;
			try {
				Object obj = ((ObjectMessage) message).getObject();
				if (obj instanceof CreateAccountDataAsync) {
					data = (CreateAccountDataAsync) obj;
					AccountData createAccount = accountBusinessServiceProxy.createAccount(data);
					createAccountServiceAsync.finalizeSuccess(new CreateAccountSuccessImpl(data
							.getAsyncResponseId(), createAccount));
				} else {
					LOG.warn("object is type of: " + obj.getClass().getCanonicalName());
				}
			} catch (Throwable e) {
				LOG.warn(e.getMessage(), e);
				try {
					createAccountServiceAsync.finalizeFailure(new CreateAccountFailureImpl(
							data != null ? data.getAsyncResponseId() : null, 1, e.getMessage()));
				} catch (JMSException e1) {
					LOG.error(e.getMessage(), e);
				}
			}
		} else {
			LOG.warn("message is type of: " + message.getClass().getCanonicalName());
		}
	}

}
