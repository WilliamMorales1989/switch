package com.ec.tvcable.switchaprov.service.tvconax;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.Aprov_Conax;

@Service(Aprov_Conax.class)
public class Aprov_ConaxBean implements Aprov_Conax {

	@Override
	public RespuestaConax respConax(ParametrosConax paramConax) {
		
		Yprd_apro_conax yprd_apro = new Yprd_apro_conax();
		yprd_apro.resConax(paramConax);
		
		RespuestaConax respuesta = new RespuestaConax();
		respuesta.setEstado("A");
		respuesta.setXml("xml");
		
		return respuesta;
	}
	


}
