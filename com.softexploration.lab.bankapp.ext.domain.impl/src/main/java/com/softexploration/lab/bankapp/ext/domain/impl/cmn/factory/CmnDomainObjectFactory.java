package com.softexploration.lab.bankapp.ext.domain.impl.cmn.factory;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncRequestId;
import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.impl.cmn.request.AsyncRequestIdImpl;
import com.softexploration.lab.bankapp.ext.domain.impl.cmn.request.AsyncResponseIdImpl;

public class CmnDomainObjectFactory {

	private static CmnDomainObjectFactory instance;

	private CmnDomainObjectFactory() {
	}

	public static CmnDomainObjectFactory getInstance() {
		if (instance == null) {
			instance = new CmnDomainObjectFactory();
		}
		return instance;
	}

	public AsyncRequestId createAsyncRequestId(Long externalRequestId) {
		AsyncRequestIdImpl ret = new AsyncRequestIdImpl(externalRequestId);
		return ret;
	}

	public AsyncResponseId createAsyncResponseId(Long internalRequestId, Long externalRequestId) {
		AsyncResponseIdImpl ret = new AsyncResponseIdImpl(internalRequestId, externalRequestId);
		return ret;
	}
}
