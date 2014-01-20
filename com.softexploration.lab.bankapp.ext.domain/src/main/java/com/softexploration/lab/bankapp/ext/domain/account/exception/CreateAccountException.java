package com.softexploration.lab.bankapp.ext.domain.account.exception;

import javax.ejb.ApplicationException;

import com.softexploration.lab.bankapp.ext.domain.cmn.exception.ServiceException;

@ApplicationException(rollback = true)
public class CreateAccountException extends ServiceException {

	private static final long serialVersionUID = -122673816352102206L;

	public CreateAccountException() {
		super();
	}

	public CreateAccountException(String message) {
		super(message);
	}

	public CreateAccountException(String message, Throwable cause) {
		super(message, cause);
	}

}
