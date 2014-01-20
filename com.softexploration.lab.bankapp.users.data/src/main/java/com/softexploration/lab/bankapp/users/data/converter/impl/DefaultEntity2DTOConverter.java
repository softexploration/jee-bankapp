package com.softexploration.lab.bankapp.users.data.converter.impl;

import com.softexploration.lab.bankapp.domain.cmn.dto.factory.DTOFactory;
import com.softexploration.lab.bankapp.domain.user.dto.UserDTO;
import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.impl.address.factory.AddressExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.impl.user.factory.UserExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;
import com.softexploration.lab.bankapp.users.data.converter.Entity2DTOConverter;
import com.softexploration.lab.bankapp.users.data.entities.Address;
import com.softexploration.lab.bankapp.users.data.entities.User;

public class DefaultEntity2DTOConverter implements Entity2DTOConverter {

	public UserDTO convert(User entity, Address address1, Address address2) {
		AddressData addressData1 = null;
		AddressData addressData2 = null;
		if (address1 != null) {
			addressData1 = AddressExtDomainObjectFactory.getInstance().createAddressData(
					AddressExtDomainObjectFactory.getInstance().createAddressId(address1.getId()),
					address1.getRegion(), address1.getCountry(), address1.getCity(),
					address1.getZip(), address1.getStreet());
		}
		if (address2 != null) {
			addressData2 = AddressExtDomainObjectFactory.getInstance().createAddressData(
					AddressExtDomainObjectFactory.getInstance().createAddressId(address2.getId()),
					address2.getRegion(), address2.getCountry(), address2.getCity(),
					address2.getZip(), address2.getStreet());
		}
		return DTOFactory.getInstance().createUserDTO(
				UserExtDomainObjectFactory.getInstance().createUserId(entity.getId()),
				entity.getName1(), entity.getName2(), addressData1, addressData2,
				entity.getStatus());
	}

	public void convert(CreateUserData source, User dest) {
		if (source.getUserData().getAddress1() != null) {
			dest.setAddress1(source.getUserData().getAddress1().getId().getId());
		}
		if (source.getUserData().getAddress2() != null) {
			dest.setAddress2(source.getUserData().getAddress2().getId().getId());
		}
		if (source.getUserData().getId() != null) {
			dest.setId(source.getUserData().getId().getId());
		}
		dest.setName1(source.getUserData().getName1());
		dest.setName2(source.getUserData().getName2());
		dest.setStatus(source.getUserData().getStatus());
	}
}
