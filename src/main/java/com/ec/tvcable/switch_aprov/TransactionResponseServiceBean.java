/**
 * 
 */
package com.ec.tvcable.switch_aprov;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switch_aprov.jpa.TransactionSpResponse;

/**
 * @author pablo
 *
 */
@Service(TransactionResponseService.class)
public class TransactionResponseServiceBean implements TransactionResponseService {

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.ec.tvcable.switch_aprov.TransactionResponseService#store(com.ec.tvcable.switch_aprov.jpa.TransactionSpResponse)
	 */
	@Override
	public void store(TransactionSpResponse transactionResponse) {
		em.persist(transactionResponse);
	}

}
