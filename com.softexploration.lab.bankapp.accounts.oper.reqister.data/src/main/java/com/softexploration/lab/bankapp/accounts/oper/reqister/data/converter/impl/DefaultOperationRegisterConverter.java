package com.softexploration.lab.bankapp.accounts.oper.reqister.data.converter.impl;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.data.converter.OperationRegisterConverter;
import com.softexploration.lab.bankapp.accounts.oper.reqister.data.entities.OperationRegisterEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.impl.OperationEntryIdImpl;
import com.softexploration.lab.bankapp.accounts.oper.reqister.impl.OperationEntryImpl;

public class DefaultOperationRegisterConverter implements OperationRegisterConverter {

	public OperationEntry convert(OperationRegisterEntry entity) {
		OperationEntryImpl ret = new OperationEntryImpl(new OperationEntryIdImpl(entity.getId()),
				entity.getOperationType(), entity.getOperationStatus(), entity.getInternalId(),
				entity.getExternalId(), entity.getRequestTime());
		return ret;
	}

	public void convert(OperationEntry source, OperationRegisterEntry dest) {
		if (source.getId() != null) {
			dest.setId(source.getId().getId());
		}
		dest.setExternalId(source.getExternalId());
		dest.setInternalId(source.getInternalId());
		dest.setOperationStatus(source.getOperationStatus());
		dest.setOperationType(source.getOperationType());
		dest.setRequestTime(source.getRequestTime());
	}

}
