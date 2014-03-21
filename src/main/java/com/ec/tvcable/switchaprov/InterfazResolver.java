/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.util.List;

import com.ec.tvcable.switchaprov.exception.AprovisionamientoException;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;

/**
 * @author pablo
 *
 */
public interface InterfazResolver {

	public List<InterfazAprovisionamiento> resolveInterfaces(Operation operation) throws AprovisionamientoException;

}
