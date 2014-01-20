package com.softexploration.lab.bankapp.cmn.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import com.softexploration.lab.bankapp.accounts.service.AccountBusinessService;
import com.softexploration.lab.bankapp.cmn.service.ListBusinessService;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.account.AccountDataProfile;
import com.softexploration.lab.bankapp.ext.domain.impl.account.factory.AccountExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.impl.user.factory.UserExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.order.OrderCriteria;
import com.softexploration.lab.bankapp.ext.domain.search.SearchCriteria;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserDataProfile;
import com.softexploration.lab.bankapp.users.service.UserBusinessService;

@Stateless(name = "defaultListService")
@Local(ListBusinessService.class)
@EJBs({ @EJB(name = "userBusinessService", beanInterface = UserBusinessService.class, beanName = "defaultUserBusinessService") })
public class DefaultListBusinessService implements ListBusinessService {
	
	@Resource
	private SessionContext ctx;

	@EJB
	private AccountBusinessService accountBusinessService;

	private UserBusinessService userBusinessService;

	public List<UserDataProfile> getAllUsers() {
		List<UserDataProfile> ret = new ArrayList<UserDataProfile>();
		List<UserData> allUsers = getUserBusinessService().getAllUsers();
		for (UserData userData : allUsers) {
			List<AccountData> accounts = accountBusinessService
					.getAccountsForUser(userData.getId());
			UserDataProfile userDataProfile = UserExtDomainObjectFactory.getInstance()
					.createUserDataProfile(userData.getId(), userData.getName1(),
							userData.getName2(), userData.getAddress1(), userData.getAddress2(),
							userData.getStatus(), accounts);
			ret.add(userDataProfile);
		}
		return ret;
	}

	public List<AccountDataProfile> getAllAccounts() {
		List<AccountDataProfile> ret = new ArrayList<AccountDataProfile>();
		List<AccountData> accounts = accountBusinessService.getAllAccounts();
		for (AccountData accountData : accounts) {
			AccountDataProfile accountDataProfile = AccountExtDomainObjectFactory.getInstance()
					.createAccountDataProfile(accountData.getId(), accountData.getName1(),
							accountData.getAccountType(), accountData.getAccountStatus(),
							accountData.getUserId(),
							getUserBusinessService().getUser(accountData.getUserId()));
			ret.add(accountDataProfile);
		}
		return ret;
	}

	public List<UserDataProfile> getUsers(SearchCriteria searchCriteria, OrderCriteria orderCriteria) {
		return null;
	}

	public List<AccountDataProfile> getAccounts(SearchCriteria searchCriteria,
			OrderCriteria orderCriteria) {
		return null;
	}

	public UserBusinessService getUserBusinessService() {
		if (userBusinessService == null) {
			userBusinessService = (UserBusinessService) ctx.lookup("userBusinessService");
		}
		return userBusinessService;
	}

}
