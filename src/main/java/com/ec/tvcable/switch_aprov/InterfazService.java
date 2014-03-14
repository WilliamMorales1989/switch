/**
 * 
 */
package com.ec.tvcable.switch_aprov;

import com.ec.tvcable.switch_aprov.servicio.tvpagada.Comando;

/**
 * @author pablo
 *
 */
public interface InterfazService {

	public Comando generarComando(String codigoServicio);

}
