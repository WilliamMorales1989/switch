/**
 * 
 */
package com.ec.tvcable.switchaprov;

import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.jpa.TransactionSpTvPagada;

/**
 * @author pablo
 *
 */
public interface DatosTvPagada {

	TransactionSpTvPagada findByDevice(DeviceProcess deviceProcess) throws DataQueryException;

}
