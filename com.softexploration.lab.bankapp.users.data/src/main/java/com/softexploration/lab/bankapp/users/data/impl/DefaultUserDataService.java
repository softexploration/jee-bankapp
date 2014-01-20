package com.softexploration.lab.bankapp.users.data.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.softexploration.lab.bankapp.domain.user.dto.UserDTO;
import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;
import com.softexploration.lab.bankapp.ext.domain.user.create.CreateUserData;
import com.softexploration.lab.bankapp.ext.domain.user.update.UpdateUserData;
import com.softexploration.lab.bankapp.users.data.UserDataService;
import com.softexploration.lab.bankapp.users.data.converter.provider.Entity2DTOConverterProvider;
import com.softexploration.lab.bankapp.users.data.entities.Address;
import com.softexploration.lab.bankapp.users.data.entities.User;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DefaultUserDataService implements UserDataService {

	@PersistenceContext(unitName = "bankapp")
	private EntityManager em;

	public UserDTO createUser(CreateUserData data) {
		Address address1 = null;
		Address address2 = null;
		if (data.getUserData().getAddress1() != null) {
			address1 = createAddress(data.getUserData().getAddress1());
		}
		if (data.getUserData().getAddress2() != null) {
			address2 = createAddress(data.getUserData().getAddress2());
		}
		User user = createUser(data.getUserData(), address1, address2);
		return Entity2DTOConverterProvider.getConverterInstance().convert(user, address1, address2);
	}

	public UserDTO getUser(UserId id) {
		Address address1 = null;
		Address address2 = null;
		User user = em.find(User.class, id.getId());
		if (user != null) {
			if (user.getAddress1() != null) {
				address1 = em.find(Address.class, user.getAddress1());
			}
			if (user.getAddress2() != null) {
				address2 = em.find(Address.class, user.getAddress2());
			}
		}
		return Entity2DTOConverterProvider.getConverterInstance().convert(user, address1, address2);
	}

	public UserDTO updateUser(UpdateUserData data) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO removeUser(UserId id) {
		Address address1 = null;
		Address address2 = null;
		User user = em.find(User.class, id.getId());
		if (user != null) {
			if (user.getAddress1() != null) {
				address1 = em.find(Address.class, user.getAddress1());
			}
			if (user.getAddress2() != null) {
				address2 = em.find(Address.class, user.getAddress2());
			}
		}
		UserDTO dto = Entity2DTOConverterProvider.getConverterInstance().convert(user, address1,
				address2);
		if (address1 != null) {
			em.remove(address1);
		}
		if (address2 != null) {
			em.remove(address2);
		}
		em.remove(user);
		return dto;
	}

	private User createUser(UserData userData, Address address1, Address address2) {
		User entity = new User();
		if (address1 != null) {
			entity.setAddress1(address1.getId());
		}
		if (address2 != null) {
			entity.setAddress2(address2.getId());
		}
		entity.setName1(userData.getName1());
		entity.setName2(userData.getName2());
		entity.setStatus(userData.getStatus());
		em.persist(entity);
		return entity;
	}

	private Address createAddress(AddressData data) {
		Address entity = new Address();
		entity.setCity(data.getCity());
		entity.setCountry(data.getCountry());
		entity.setRegion(data.getRegion());
		entity.setStreet(data.getStreet());
		entity.setZip(data.getZip());
		em.persist(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UserDTO> getAllUsers() {
		List<UserDTO> ret = new ArrayList<UserDTO>();
		List<User> list = em.createNamedQuery("User.findAllUsers").getResultList();
		for (User user : list) {
			Address address1 = null;
			Address address2 = null;
			if (user.getAddress1() != null) {
				address1 = em.find(Address.class, user.getAddress1());
			}
			if (user.getAddress2() != null) {
				address2 = em.find(Address.class, user.getAddress2());
			}
			UserDTO dto = Entity2DTOConverterProvider.getConverterInstance().convert(user,
					address1, address2);
			ret.add(dto);
		}
		return ret;
	}

}
