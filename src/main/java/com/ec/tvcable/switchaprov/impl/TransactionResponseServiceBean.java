/**
 * 
 */
package com.ec.tvcable.switchaprov.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.TransactionSpResponseService;
import com.ec.tvcable.switchaprov.jpa.TransactionHeaderResponse;

/**
 * @author pablo
 * 
 */
@Service(TransactionSpResponseService.class)
public class TransactionResponseServiceBean implements TransactionSpResponseService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveHeader(TransactionHeaderResponse transactionHeaderResponse) {
		em.persist(transactionHeaderResponse);
	}

}
