package com.softexploration.lab.bankapp.users.service.create.process.internal.type;

import java.io.Serializable;

import com.softexploration.lab.bankapp.ext.domain.cmn.AsyncResponseId;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;

public interface CreateUserSuccess extends Serializable {

	AsyncResponseId getAsyncResponseId();

	UserData getUserData();
}
