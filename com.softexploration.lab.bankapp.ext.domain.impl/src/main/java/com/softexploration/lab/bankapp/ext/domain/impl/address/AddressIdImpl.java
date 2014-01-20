package com.softexploration.lab.bankapp.ext.domain.impl.address;

import com.softexploration.lab.bankapp.ext.domain.address.AddressId;

public class AddressIdImpl implements AddressId {

	private static final long serialVersionUID = 1188937172330120509L;

	private Long id;

	public AddressIdImpl(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
