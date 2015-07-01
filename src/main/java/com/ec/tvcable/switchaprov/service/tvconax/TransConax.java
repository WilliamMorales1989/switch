package com.ec.tvcable.switchaprov.service.tvconax;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;

public final class TransConax {

	@Transformer(to = "{urn:com.example.switchyard:ServicioConax:1.0}respuestaServico")
	public Element transformDatosServicioToRespuestaServico(DatosServicio from) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transformer(from = "{urn:com.example.switchyard:ServicioConax:1.0}respuestaServicoResponse")
	public RespuestaServicoConax transformRespuestaServicoResponseToRespuestaServicoConax(Element from) {
		// TODO Auto-generated method stub
		return null;
	}

}
