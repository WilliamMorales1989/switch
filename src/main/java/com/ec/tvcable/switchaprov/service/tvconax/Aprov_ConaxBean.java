package com.ec.tvcable.switchaprov.service.tvconax;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.Aprov_Conax;

@Service(Aprov_Conax.class)
public class Aprov_ConaxBean implements Aprov_Conax {

	private RespuestaConax respuestaconax;
	@Override
	public RespuestaConax respConax(ParametrosConax paramConax) {
		
		Yprd_apro_conax yprd_apro = new Yprd_apro_conax();
		respuestaconax = yprd_apro.resConax(paramConax);
		
		return respuestaconax;
	}
	


}
