package com.softexploration.lab.bankapp.users.data.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.softexploration.lab.bankapp.ext.domain.user.UserStatus;

@Entity
@Table(name = "user")
@NamedQueries({ @NamedQuery(name = "User.findAllUsers", query = "select u from User u") })
public class User implements Serializable {

	private static final long serialVersionUID = 7817522372728100862L;

	private Long id;
	private String name1;
	private String name2;
	private Long address1;
	private Long address2;
	private UserStatus status;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "name1")
	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "name2")
	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	@Column(name = "address1")
	public Long getAddress1() {
		return address1;
	}

	public void setAddress1(Long address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public Long getAddress2() {
		return address2;
	}

	public void setAddress2(Long address2) {
		this.address2 = address2;
	}

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

}
