package com.softexploration.lab.bankapp.ext.domain.impl.address.factory;

import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.address.AddressId;
import com.softexploration.lab.bankapp.ext.domain.impl.address.AddressDataImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.address.AddressIdImpl;

public class AddressExtDomainObjectFactory {

	private static AddressExtDomainObjectFactory instance;

	private AddressExtDomainObjectFactory() {
	}

	public static AddressExtDomainObjectFactory getInstance() {
		if (instance == null) {
			instance = new AddressExtDomainObjectFactory();
		}
		return instance;
	}

	public AddressId createAddressId(Long id) {
		return new AddressIdImpl(id);
	}

	public AddressData createAddressData(AddressId id, String region, String country, String city,
			String zip, String street) {
		return new AddressDataImpl(id, region, country, city, zip, street);
	}
}
