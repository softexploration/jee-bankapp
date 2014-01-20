package com.softexploration.lab.bankapp.ext.domain.cmn.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -122673816352102206L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
