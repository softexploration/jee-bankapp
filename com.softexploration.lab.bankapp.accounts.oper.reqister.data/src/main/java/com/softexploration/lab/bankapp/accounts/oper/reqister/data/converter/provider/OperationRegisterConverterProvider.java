package com.softexploration.lab.bankapp.accounts.oper.reqister.data.converter.provider;

import com.softexploration.lab.bankapp.accounts.oper.reqister.data.converter.OperationRegisterConverter;
import com.softexploration.lab.bankapp.accounts.oper.reqister.data.converter.impl.DefaultOperationRegisterConverter;

public class OperationRegisterConverterProvider {

	private static OperationRegisterConverter converterInstance;

	public static OperationRegisterConverter getConverterInstance() {
		if (converterInstance == null) {
			converterInstance = new DefaultOperationRegisterConverter();
		}
		return converterInstance;
	}
}
