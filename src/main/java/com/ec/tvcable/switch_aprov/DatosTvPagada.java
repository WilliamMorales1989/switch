/**
 * 
 */
package com.ec.tvcable.switch_aprov;

import com.ec.tvcable.switch_aprov.exception.DataQueryException;
import com.ec.tvcable.switch_aprov.jpa.TransactionSpTvPagada;

/**
 * @author pablo
 *
 */
public interface DatosTvPagada {

	TransactionSpTvPagada findByDevice(String processId) throws DataQueryException;

}
