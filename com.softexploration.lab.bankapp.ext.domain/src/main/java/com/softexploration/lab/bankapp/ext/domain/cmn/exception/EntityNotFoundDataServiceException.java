package com.softexploration.lab.bankapp.ext.domain.cmn.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class EntityNotFoundDataServiceException extends RuntimeException {

	private static final long serialVersionUID = -122673816352102206L;

	public EntityNotFoundDataServiceException() {
		super();
	}

	public EntityNotFoundDataServiceException(String message) {
		super(message);
	}

	public EntityNotFoundDataServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
