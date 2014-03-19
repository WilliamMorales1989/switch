/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.util.List;

import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;

/**
 * @author pablo
 *
 */
public interface InterfazAprovServicio {
	
	List<InterfazAprovisionamiento> buscarPorAprovisionamiento(Operation operation);

}
