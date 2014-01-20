package com.softexploration.lab.bankapp.accounts.service.converter;

import java.util.List;

import com.softexploration.lab.bankapp.domain.account.dto.AccountDTO;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;

public interface DTO2BusinessTypeConverter {

	AccountData convert(AccountDTO dto);

	List<AccountData> convert(List<AccountDTO> accounts);
}
