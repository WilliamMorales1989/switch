/**
 * 
 */
package com.ec.tvcable.switchaprov;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.jpa.TransactionSpResponse;

/**
 * @author pablo
 *
 */
@Service(TransactionSpResponseService.class)
public class TransactionResponseServiceBean implements TransactionSpResponseService {

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.ec.tvcable.switchaprov.TransactionSpResponseService#store(com.ec.tvcable.switchaprov.jpa.TransactionSpResponse)
	 */
	@Override
	public void store(TransactionSpResponse transactionResponse) {
		em.persist(transactionResponse);
	}

}
