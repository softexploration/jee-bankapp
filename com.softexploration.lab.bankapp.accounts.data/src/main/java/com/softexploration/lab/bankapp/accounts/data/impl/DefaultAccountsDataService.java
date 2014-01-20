/**
 * 
 */
package com.softexploration.lab.bankapp.accounts.data.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.softexploration.lab.bankapp.accounts.data.AccountDataService;
import com.softexploration.lab.bankapp.accounts.data.converter.provider.Entity2DTOConverterProvider;
import com.softexploration.lab.bankapp.accounts.data.entities.Account;
import com.softexploration.lab.bankapp.domain.account.dto.AccountDTO;
import com.softexploration.lab.bankapp.ext.domain.account.AccountId;
import com.softexploration.lab.bankapp.ext.domain.account.create.CreateAccountData;
import com.softexploration.lab.bankapp.ext.domain.account.update.UpdateAccountData;
import com.softexploration.lab.bankapp.ext.domain.cmn.exception.EntityNotFoundDataServiceException;
import com.softexploration.lab.bankapp.ext.domain.user.UserId;

/**
 * @author Tomek
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DefaultAccountsDataService implements AccountDataService {

	@PersistenceContext(unitName = "bankapp")
	private EntityManager entityManager;

	public AccountDTO createAccount(CreateAccountData data) {
		Account account = new Account();
		Entity2DTOConverterProvider.getConverterInstance().convert(data, account);
		entityManager.persist(account);
		return Entity2DTOConverterProvider.getConverterInstance().convert(account);
	}

	public AccountDTO getAccount(AccountId id) {
		Account account = entityManager.find(Account.class, id.getNumber());
		if (account == null) {
			throw new EntityNotFoundDataServiceException();
		}
		return Entity2DTOConverterProvider.getConverterInstance().convert(account);
	}

	public AccountDTO updateAccount(UpdateAccountData data) {
		Account account = entityManager.find(Account.class, null);
		// TODO
		return Entity2DTOConverterProvider.getConverterInstance().convert(account);
	}

	public AccountDTO removeAccount(AccountId id) {
		Account account = entityManager.find(Account.class, id.getNumber());
		AccountDTO ret = Entity2DTOConverterProvider.getConverterInstance().convert(account);
		entityManager.remove(account);
		return ret;
	}

	public List<AccountDTO> getAllAccounts() {
		List<Account> resultList = entityManager.createNamedQuery("Account.findAllAccounts",
				Account.class).getResultList();
		return Entity2DTOConverterProvider.getConverterInstance().convert(resultList);
	}

	public List<AccountDTO> getAccountsForUser(UserId userId) {
		@SuppressWarnings("unchecked")
		List<Account> resultList = entityManager.createNamedQuery("Account.findAccountsForUser")
				.setParameter(1, userId.getId()).getResultList();
		return Entity2DTOConverterProvider.getConverterInstance().convert(resultList);
	}

}
