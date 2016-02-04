package com.ec.tvcable.switchaprov.TvPagadaSGR;

import com.ec.tvcable.switchaprov.AprovisionamientoSGR.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;

public interface TvPagadaSGR {
	
	public Respuesta resp (Aprovisionamiento_Type parametros);

}
