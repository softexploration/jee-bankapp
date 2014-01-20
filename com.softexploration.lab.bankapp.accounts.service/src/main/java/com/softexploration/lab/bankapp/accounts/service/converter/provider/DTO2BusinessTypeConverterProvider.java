package com.softexploration.lab.bankapp.accounts.service.converter.provider;

import com.softexploration.lab.bankapp.accounts.service.converter.DTO2BusinessTypeConverter;
import com.softexploration.lab.bankapp.accounts.service.converter.impl.DefaultDTO2BusinessTypeConverter;

public class DTO2BusinessTypeConverterProvider {

	private static DTO2BusinessTypeConverter converterInstance;

	public static DTO2BusinessTypeConverter getConverterInstance() {
		if (converterInstance == null) {
			converterInstance = new DefaultDTO2BusinessTypeConverter();
		}
		return converterInstance;
	}
}
