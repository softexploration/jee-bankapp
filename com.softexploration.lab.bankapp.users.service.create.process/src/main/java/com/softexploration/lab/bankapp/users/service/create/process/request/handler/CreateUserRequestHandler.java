package com.softexploration.lab.bankapp.users.service.create.process.request.handler;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.softexploration.lab.bankapp.domain.user.async.CreateUserDataAsync;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.users.service.UserBusinessService;
import com.softexploration.lab.bankapp.users.service.create.process.internal.CreateUserServiceAsync;
import com.softexploration.lab.bankapp.users.service.create.process.internal.type.impl.CreateUserFailureImpl;
import com.softexploration.lab.bankapp.users.service.create.process.internal.type.impl.CreateUserSuccessImpl;

import org.apache.log4j.Logger;

@MessageDriven(mappedName = "jms/createUserRequestQueue", messageListenerInterface = MessageListener.class, activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class CreateUserRequestHandler {

	@EJB(beanName = "userBusinessServiceProxy")
	private UserBusinessService userBusinessService;

	@EJB
	private CreateUserServiceAsync createUserServiceAsync;

	private static final Logger LOG = Logger.getLogger(CreateUserRequestHandler.class);

	public void onMessage(Message message) {

		if (message instanceof ObjectMessage) {
			CreateUserDataAsync data = null;
			try {
				Object obj = ((ObjectMessage) message).getObject();
				if (obj instanceof CreateUserDataAsync) {
					data = (CreateUserDataAsync) obj;
					UserData createUser = userBusinessService.createUser(data);
					createUserServiceAsync.finalizeSuccess(new CreateUserSuccessImpl(data
							.getAsyncResponseId(), createUser));
				} else {
					LOG.warn("object is type of: " + obj.getClass().getCanonicalName());
				}
			} catch (Throwable e) {
				LOG.warn(e.getMessage(), e);
				try {
					createUserServiceAsync.finalizeFailure(new CreateUserFailureImpl(
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
