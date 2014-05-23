/**
 * 
 */
package com.ec.tvcable.switchaprov;

import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.jpa.TransactionSpIntraway;
/**
 * @author Mauricio
 *
 */
public interface DatosIntraway {

	TransactionSpIntraway findByDevice(DeviceProcess deviceProcess) throws DataQueryException;

}
