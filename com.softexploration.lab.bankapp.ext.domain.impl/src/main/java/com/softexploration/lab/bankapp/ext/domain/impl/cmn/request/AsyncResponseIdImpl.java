package com.softexploration.lab.bankapp.ext.domain.impl.cmn.request;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

public class AsyncResponseIdImpl implements AsyncResponseId {

	private static final long serialVersionUID = 1L;

	private Long internalRequestId;
	private Long externalRequestId;

	public AsyncResponseIdImpl(Long internalRequestId, Long externalRequestId) {
		super();
		this.internalRequestId = internalRequestId;
		this.externalRequestId = externalRequestId;
	}

	public Long getInternalRequestId() {
		return internalRequestId;
	}

	public Long getExternalRequestId() {
		return externalRequestId;
	}

}
