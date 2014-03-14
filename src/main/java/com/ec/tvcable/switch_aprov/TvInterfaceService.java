/**
 * 
 */
package com.ec.tvcable.switch_aprov;

import java.util.List;

import com.ec.tvcable.switch_aprov.servicio.tvpagada.Comando;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Respuesta;

/**
 * @author pablo
 * 
 */
public interface TvInterfaceService {

	public InterfaceInvocationResponse generateResponse();

	public Respuesta invokeAprovTvpagada(Comando comando);

	public List<InterfaceInvocationResponse> invokeInterfaces(ComandoEmsInterfaces comandoEmsInterfaces);
}
