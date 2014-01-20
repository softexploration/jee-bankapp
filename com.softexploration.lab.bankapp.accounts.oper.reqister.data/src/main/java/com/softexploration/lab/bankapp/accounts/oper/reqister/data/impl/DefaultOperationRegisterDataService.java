package com.softexploration.lab.bankapp.accounts.oper.reqister.data.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntry;
import com.softexploration.lab.bankapp.accounts.oper.reqister.OperationEntryId;
import com.softexploration.lab.bankapp.accounts.oper.reqister.data.OperationRegisterDataService;
import com.softexploration.lab.bankapp.accounts.oper.reqister.data.converter.provider.OperationRegisterConverterProvider;
import com.softexploration.lab.bankapp.accounts.oper.reqister.data.entities.OperationRegisterEntry;

@Stateless
@Local({ OperationRegisterDataService.class })
public class DefaultOperationRegisterDataService implements OperationRegisterDataService {

	@PersistenceContext(unitName = "bankapp")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public OperationEntry reqister(OperationEntry entry) {
		OperationRegisterEntry entity = new OperationRegisterEntry();
		OperationRegisterConverterProvider.getConverterInstance().convert(entry, entity);
		em.persist(entity);
		return OperationRegisterConverterProvider.getConverterInstance().convert(entity);
	}

	public OperationEntry get(OperationEntryId id) {
		OperationRegisterEntry entity = em.find(OperationRegisterEntry.class, id.getId());
		return OperationRegisterConverterProvider.getConverterInstance().convert(entity);
	}

}
