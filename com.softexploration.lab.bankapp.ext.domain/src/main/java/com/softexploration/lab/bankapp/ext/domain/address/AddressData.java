package com.softexploration.lab.bankapp.ext.domain.address;

import java.io.Serializable;

public interface AddressData extends Serializable {

	AddressId getId();

	String getRegion();

	String getCountry();

	String getCity();

	String getZip();

	String getStreet();
}
