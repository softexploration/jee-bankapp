package com.softexploration.lab.bankapp.accounts.data.converter.provider;

import com.softexploration.lab.bankapp.accounts.data.converter.Entity2DTOConverter;
import com.softexploration.lab.bankapp.accounts.data.converter.impl.DefaultEntity2DTOConverter;

public class Entity2DTOConverterProvider {

	private static Entity2DTOConverter converterInstance;

	public static Entity2DTOConverter getConverterInstance() {
		if (converterInstance == null) {
			converterInstance = new DefaultEntity2DTOConverter();
		}
		return converterInstance;
	}

}
