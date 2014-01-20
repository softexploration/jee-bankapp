package com.softexploration.lab.bankapp.users.service.create.finalize;

import java.io.Serializable;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.softexploration.lab.bankapp.ext.domain.account.response.CreateAccountDataResponse;

import org.apache.log4j.Logger;

@MessageDriven(mappedName = "jms/createUserResponseQueue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class UserCreatedResponseHandler implements MessageListener {

	private static final Logger LOG = Logger.getLogger(UserCreatedResponseHandler.class);

	public void onMessage(Message message) {
		System.out.println("UserCreatedResponseHandler");
		if (message instanceof ObjectMessage) {
			try {
				Serializable object = ((ObjectMessage) message).getObject();
				if (object instanceof CreateAccountDataResponse) {
					CreateAccountDataResponse response = (CreateAccountDataResponse) object;
					LOG.info("response: " + response);
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

}
