/**
 * 
 */
package com.ec.tvcable.switchaprov;

import com.ec.tvcable.switchaprov.service.tvpagada.Comando;

/**
 * @author pablo
 *
 */
public interface InterfazService {

	public Comando generarComando(String codigoServicio);

}
