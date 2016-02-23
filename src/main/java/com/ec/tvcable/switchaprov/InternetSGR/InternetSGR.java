package com.ec.tvcable.switchaprov.InternetSGR;

import com.ec.tvcable.switchaprov.AprovisionamientoSGR.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;

public interface InternetSGR {
	
	public Respuesta resp (Aprovisionamiento_Type parametros);

}
