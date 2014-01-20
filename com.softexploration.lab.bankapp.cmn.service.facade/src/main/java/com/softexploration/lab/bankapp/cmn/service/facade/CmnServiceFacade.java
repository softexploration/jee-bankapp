package com.softexploration.lab.bankapp.cmn.service.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.softexploration.lab.bankapp.cmn.service.ListBusinessService;
import com.softexploration.lab.bankapp.ext.cmn.service.api.ListService;
import com.softexploration.lab.bankapp.ext.cmn.service.api.local.ListServiceLocal;
import com.softexploration.lab.bankapp.ext.domain.account.AccountDataProfile;
import com.softexploration.lab.bankapp.ext.domain.user.UserDataProfile;

@Remote(ListService.class)
@Local(ListServiceLocal.class)
@Stateless
public class CmnServiceFacade implements ListServiceLocal {

	@EJB
	private ListBusinessService listBusinessService;

	public List<UserDataProfile> getAllUsers() {
		return listBusinessService.getAllUsers();
	}

	public List<AccountDataProfile> getAllAccounts() {
		return listBusinessService.getAllAccounts();
	}

}
