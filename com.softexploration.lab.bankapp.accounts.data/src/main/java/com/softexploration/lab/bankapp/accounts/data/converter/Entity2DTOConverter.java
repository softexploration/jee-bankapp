package com.softexploration.lab.bankapp.accounts.data.converter;

import java.util.List;

import com.softexploration.lab.bankapp.accounts.data.entities.Account;
import com.softexploration.lab.bankapp.domain.account.dto.AccountDTO;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;

public interface Entity2DTOConverter {

	AccountDTO convert(Account account);

	List<AccountDTO> convert(List<Account> list);

	void convert(CreateAccountData source, Account dest);
}
