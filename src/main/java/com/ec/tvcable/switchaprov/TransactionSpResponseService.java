/**
 * 
 */
package com.ec.tvcable.switchaprov;

import com.ec.tvcable.switchaprov.jpa.TransactionHeaderResponse;

/**
 * @author pablo
 *
 */
public interface TransactionSpResponseService {

	void saveHeader(TransactionHeaderResponse transactionHeaderResponse);

}
