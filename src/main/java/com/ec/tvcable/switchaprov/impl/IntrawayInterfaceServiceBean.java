/**
 * 
 */
package com.ec.tvcable.switchaprov.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.ComandoInterfaces;
import com.ec.tvcable.switchaprov.InterfaceInvocationResponse;
import com.ec.tvcable.switchaprov.IntrawayInterfaceService;
import com.ec.tvcable.switchaprov.service.ems.EMS_Type;
import com.ec.tvcable.switchaprov.service.intraway.Cabecera;
import com.ec.tvcable.switchaprov.service.intraway.Comando;
import com.ec.tvcable.switchaprov.service.intraway.Respuesta;
import com.ec.tvcable.switchaprov.service.intraway.WsdlIntraway;

/**
 * @author pablo
 * 
 */
@Service(IntrawayInterfaceService.class)
public class IntrawayInterfaceServiceBean implements IntrawayInterfaceService {

	@Reference @Inject
	WsdlIntraway wsdlIntraway;
	
	@Override
	public List<InterfaceInvocationResponse> invokeInterfaces(ComandoInterfaces comandoInterfaces) {
		Comando comando = createComando();
		invocarAprovTvpagada(comando);
		
		List<InterfaceInvocationResponse> responses = new ArrayList<InterfaceInvocationResponse>();
		
		return responses;
	}

	private Comando createComando() {
		Comando comando = new Comando();
		Cabecera cabecera = new Cabecera();
		cabecera.setIDEmpresa(600);
		comando.setCabecera(cabecera);
		return comando;
	}

	private String invocarAprovTvpagada(Comando comando) {
		Respuesta respuesta = wsdlIntraway.AprovIntraway(comando);
		return respuesta.getMensaje().getDetMensaje();
	}
	
}
