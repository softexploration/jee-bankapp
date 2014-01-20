package com.softexploration.lab.bankapp.cmn.service;

import java.util.List;

import com.softexploration.lab.bankapp.ext.domain.account.AccountDataProfile;
import com.softexploration.lab.bankapp.ext.domain.order.OrderCriteria;
import com.softexploration.lab.bankapp.ext.domain.search.SearchCriteria;
import com.softexploration.lab.bankapp.ext.domain.user.UserDataProfile;

public interface ListBusinessService {

	List<UserDataProfile> getAllUsers();

	List<AccountDataProfile> getAllAccounts();

	List<UserDataProfile> getUsers(SearchCriteria searchCriteria, OrderCriteria orderCriteria);

	List<AccountDataProfile> getAccounts(SearchCriteria searchCriteria, OrderCriteria orderCriteria);
}
