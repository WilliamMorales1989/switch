/**
 * 
 */
package com.ec.tvcable.switch_aprov;

import java.util.List;

import com.ec.tvcable.switch_aprov.jpa.InterfazAprovisionamiento;

/**
 * @author pablo
 *
 */
public interface InterfazAprovServicio {
	
	List<InterfazAprovisionamiento> buscarPorAprovisionamiento(Operation operation);

}
