package com.softexploration.lab.bankapp.ext.domain.impl.address;

import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.address.AddressId;

public class AddressDataImpl implements AddressData {

	private static final long serialVersionUID = 7875151682780525930L;

	private AddressId id;
	private String region;
	private String country;
	private String city;
	private String zip;
	private String street;

	public AddressDataImpl(AddressId id, String region, String country, String city, String zip,
			String street) {
		super();
		this.id = id;
		this.region = region;
		this.country = country;
		this.city = city;
		this.zip = zip;
		this.street = street;
	}

	public AddressId getId() {
		return id;
	}

	public String getRegion() {
		return region;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getStreet() {
		return street;
	}

}
