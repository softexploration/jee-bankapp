package com.softexploration.lab.bankapp.users.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.softexploration.lab.bankapp.domain.user.dto.UserDTO;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;
import com.softexploration.lab.bankapp.users.data.UserDataService;
import com.softexploration.lab.bankapp.users.service.UserBusinessService;
import com.softexploration.lab.bankapp.users.service.converter.provider.DTO2BusinessTypeConverterProvider;

@Stateless(name = "defaultUserBusinessService")
@Local(UserBusinessService.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class DefaultUserBusinessService implements UserBusinessService {

	@Resource
	private SessionContext ctx;

	private UserDataService userDataService;

	@EJB
	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}

	public UserData createUser(CreateUserData data) {
		try {
			ctx.getUserTransaction().begin();
			UserDTO dto = userDataService.createUser(data);
			ctx.getUserTransaction().commit();
			return DTO2BusinessTypeConverterProvider.getConverterInstance().convert(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public UserData getUser(UserId id) {
		UserDTO dto = userDataService.getUser(id);
		return DTO2BusinessTypeConverterProvider.getConverterInstance().convert(dto);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UserData> getAllUsers() {
		return DTO2BusinessTypeConverterProvider.getConverterInstance().convert(
				userDataService.getAllUsers());
	}

}
