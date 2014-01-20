package com.softexploration.lab.bankapp.accounts.oper.reqister.impl;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;

public class OperationEntryIdImpl implements OperationEntryId {

	private Long id;

	public OperationEntryIdImpl(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
