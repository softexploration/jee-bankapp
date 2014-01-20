package com.softexploration.lab.bankapp.accounts.oper.reqister.data.converter;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.data.entities.OperationRegisterEntry;

public interface OperationRegisterConverter {

	OperationEntry convert(OperationRegisterEntry entity);

	void convert(OperationEntry source, OperationRegisterEntry dest);
}
