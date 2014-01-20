package com.softexploration.lab.bankapp.users.service.create.process.proxy.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;
import com.softexploration.lab.bankapp.users.service.UserBusinessService;

@Stateless(name = "userBusinessServiceProxy")
@Local(UserBusinessService.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UserBusinessServiceProxy implements UserBusinessService {

	@EJB(beanName = "defaultUserBusinessService")
	private UserBusinessService userBusinessService;

	public UserData createUser(CreateUserData data) {
		return userBusinessService.createUser(data);
	}

	public UserData getUser(UserId id) {
		return userBusinessService.getUser(id);
	}

	public List<UserData> getAllUsers() {
		return userBusinessService.getAllUsers();
	}

}
