package com.softexploration.lab.bankapp.ext.domain.impl.cmn.request;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncRequestId;

public class AsyncRequestIdImpl implements AsyncRequestId {

	private static final long serialVersionUID = 1L;

	private Long externalRequestId;

	public AsyncRequestIdImpl(Long externalRequestId) {
		super();
		this.externalRequestId = externalRequestId;
	}

	public Long getExternalRequestId() {
		return externalRequestId;
	}

}
