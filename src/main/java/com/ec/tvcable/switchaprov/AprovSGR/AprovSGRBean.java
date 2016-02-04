package com.ec.tvcable.switchaprov.AprovSGR;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.AprovisionamientoSGR.AprovisionamientoResponse;
import com.ec.tvcable.switchaprov.AprovisionamientoSGR.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.AprovisionamientoSGR.BodyResponse;
import com.ec.tvcable.switchaprov.AprovisionamientoSGR.HeaderResponse;
import com.ec.tvcable.switchaprov.InternetSGR.InternetSGR;
import com.ec.tvcable.switchaprov.TvPagadaSGR.TvPagadaSGR;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;

@Service(AprovSGR.class)
public class AprovSGRBean implements AprovSGR {

	@Reference
	@Inject
	private TvPagadaSGR tvpagada;
	
	@Reference
	@Inject
	private InternetSGR internetsgr;

	private Respuesta resp;
	@Override
	public AprovisionamientoResponse respuesta(Aprovisionamiento_Type parametros) {

		AprovisionamientoResponse respuesta = new AprovisionamientoResponse();

		if(parametros.getHeaderRequest().getSystem().equals("TV")){
			
			resp = tvpagada.resp(parametros);
				
			int coderror = resp.getMensaje().getCodError();
			
			HeaderResponse cabecera = new HeaderResponse();
			cabecera.setAplicacion(parametros.getHeaderRequest().getAplicacion());
			cabecera.setController(parametros.getHeaderRequest().getController());
			cabecera.setSystem(parametros.getHeaderRequest().getSystem());
			
			respuesta.setHeaderResponse(cabecera);
			
			BodyResponse cuerpo = new BodyResponse();
			cuerpo.setErrorCode(coderror+"");
			cuerpo.setErrorMessagge(resp.getMensaje().getDetMensaje());
			cuerpo.setIdUsuario(parametros.getBodyRequest().getIdUsuario()+"");
			cuerpo.setSerie(parametros.getBodyRequest().getSerie());
			respuesta.setBodyResponse(cuerpo);
			
		}else if (parametros.getHeaderRequest().getSystem().equals("INT")){
			
			//return null;
			
		}else if (parametros.getHeaderRequest().getSystem().equals("DTH")){
			
			//return null;
			
		}
		
		return respuesta;
		
	}
	
	
}
