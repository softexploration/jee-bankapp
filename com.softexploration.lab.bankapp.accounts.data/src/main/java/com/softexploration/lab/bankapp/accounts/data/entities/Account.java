package com.softexploration.lab.bankapp.accounts.data.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.softexploration.lab.bankapp.accounts.data.entities.listener.AccountEntityListener;
import com.softexploration.lab.bankapp.ext.domain.account.AccountStatus;
import com.softexploration.lab.bankapp.ext.domain.account.AccountType;

@Entity
@Table(name = "account")
@EntityListeners(AccountEntityListener.class)
@NamedQueries({
		@NamedQuery(name = "Account.findAllAccounts", query = "select a from Account a"),
		@NamedQuery(name = "Account.findAccountsForUser", query = "select a from Account a where a.userId=?1") })
public class Account implements Serializable {

	private static final long serialVersionUID = -1191271837831171973L;

	@Id
	private String number;

	private String name1;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;

	@Column(name = "user_id")
	private Long userId;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@PrePersist
	void pp() {
		System.out.println("internal @PrePersist");
	}
}
