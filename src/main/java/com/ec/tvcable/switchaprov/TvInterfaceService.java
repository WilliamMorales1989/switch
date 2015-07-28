/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.util.List;

import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.service.tvpagada.Comando;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;

/**
 * @author pablo
 * 
 */
public interface TvInterfaceService {

	public InterfaceInvocationResponse generateResponse();

	public Respuesta invokeAprovTvpagada(Comando comando);

	public List<InterfaceInvocationResponse> invokeInterfaces(AprovisionamientoInterfaces comandoEmsInterfaces) throws DataQueryException;

	InterfaceInvocationResponse generateResponseConax();
	
}