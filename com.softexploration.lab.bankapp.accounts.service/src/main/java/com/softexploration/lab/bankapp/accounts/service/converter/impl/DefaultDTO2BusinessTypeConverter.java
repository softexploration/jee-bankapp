package com.softexploration.lab.bankapp.accounts.service.converter.impl;

import java.util.ArrayList;
import java.util.List;

import com.softexploration.lab.bankapp.accounts.service.converter.DTO2BusinessTypeConverter;
import com.softexploration.lab.bankapp.accounts.service.converter.provider.DTO2BusinessTypeConverterProvider;
import com.softexploration.lab.bankapp.domain.account.dto.AccountDTO;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.impl.account.factory.AccountExtDomainObjectFactory;

public class DefaultDTO2BusinessTypeConverter implements DTO2BusinessTypeConverter {

	public AccountData convert(AccountDTO dto) {
		return AccountExtDomainObjectFactory.getInstance().createAccountData(dto.getId(),
				dto.getName1(), dto.getAccountType(), dto.getAccountStatus(), dto.getUserId());
	}

	public List<AccountData> convert(List<AccountDTO> accounts) {
		List<AccountData> ret = new ArrayList<AccountData>();
		for (AccountDTO accountDTO : accounts) {
			ret.add(DTO2BusinessTypeConverterProvider.getConverterInstance().convert(accountDTO));
		}
		return ret;
	}
}
