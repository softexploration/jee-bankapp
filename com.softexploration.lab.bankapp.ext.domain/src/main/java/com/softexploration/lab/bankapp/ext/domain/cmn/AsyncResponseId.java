package com.softexploration.lab.bankapp.ext.domain.cmn;

import java.io.Serializable;

public interface AsyncResponseId extends Serializable {

	Long getInternalRequestId();

	Long getExternalRequestId();
}
