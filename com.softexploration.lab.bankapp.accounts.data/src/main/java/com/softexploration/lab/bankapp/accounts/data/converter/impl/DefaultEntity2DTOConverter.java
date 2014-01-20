package com.softexploration.lab.bankapp.accounts.data.converter.impl;

import java.util.ArrayList;
import java.util.List;

import com.softexploration.lab.bankapp.accounts.data.converter.Entity2DTOConverter;
import com.softexploration.lab.bankapp.accounts.data.entities.Account;
import com.softexploration.lab.bankapp.domain.account.dto.AccountDTO;
import com.softexploration.lab.bankapp.domain.cmn.dto.factory.DTOFactory;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.impl.account.factory.AccountExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.impl.user.factory.UserExtDomainObjectFactory;

public class DefaultEntity2DTOConverter implements Entity2DTOConverter {

	public AccountDTO convert(Account account) {
		return DTOFactory.getInstance().createAccountDTO(
				AccountExtDomainObjectFactory.getInstance().createAccountId(account.getNumber()),
				account.getName1(), account.getAccountType(), account.getAccountStatus(),
				UserExtDomainObjectFactory.getInstance().createUserId(account.getUserId()));
	}

	public void convert(CreateAccountData source, Account dest) {
		dest.setNumber(source.getAccountData().getId().getNumber());
		dest.setAccountStatus(source.getAccountData().getAccountStatus());
		dest.setAccountType(source.getAccountData().getAccountType());
		dest.setName1(source.getAccountData().getName1());
		if (source.getAccountData().getUserId() != null) {
			dest.setUserId(source.getAccountData().getUserId().getId());
		}
	}

	public List<AccountDTO> convert(List<Account> list) {
		List<AccountDTO> ret = new ArrayList<AccountDTO>();
		for (Account account : list) {
			AccountDTO dto = DTOFactory.getInstance().createAccountDTO(
					AccountExtDomainObjectFactory.getInstance()
							.createAccountId(account.getNumber()), account.getName1(),
					account.getAccountType(), account.getAccountStatus(),
					UserExtDomainObjectFactory.getInstance().createUserId(account.getUserId()));
			ret.add(dto);
		}
		return ret;
	}
}
