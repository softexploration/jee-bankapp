package com.softexploration.lab.bankapp.accounts.data.entities.listener;

import javax.annotation.PreDestroy;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.softexploration.lab.bankapp.accounts.data.entities.Account;
import org.apache.log4j.Logger;

public class AccountEntityListener {

	private static final Logger LOG = Logger.getLogger(AccountEntityListener.class);

	@PrePersist
	public void f(Object entity) {
		Account account = (Account) entity;
		LOG.info(account);
		System.out.println("@PrePersist: " + account);
	}

	@PostPersist
	void g(Object entity) {
		Account account = (Account) entity;
		LOG.info(account);
		System.out.println("@PostPersist: " + account);
	}

	@PreRemove
	void h(Object entity) {
		Account account = (Account) entity;
		LOG.info(account);
		System.out.println("@PreRemove: " + account);
	}

	@PostRemove
	void i(Object entity) {
		Account account = (Account) entity;
		LOG.info(account);
		System.out.println("@PostRemove: " + account);
	}

	@PreUpdate
	void j(Object entity) {
		Account account = (Account) entity;
		LOG.info(account);
		System.out.println("@PreUpdate: " + account);
	}

	@PostUpdate
	void k(Object entity) {
		Account account = (Account) entity;
		LOG.info(account);
		System.out.println("@PostUpdate: " + account);
	}

	@PostLoad
	void l(Object entity) {
		Account account = (Account) entity;
		LOG.info(account);
		System.out.println("@PostLoad: " + account);
	}
}
