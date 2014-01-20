package com.softexploration.lab.bankapp.ext.domain.account.response;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;

/**
 * 
 * @author Tomasz Lepiorz
 * 
 */
public interface CreateAccountDataAcceptedRequestResponse extends Serializable {

	AsyncResponseId getAsyncResponseId();
}
