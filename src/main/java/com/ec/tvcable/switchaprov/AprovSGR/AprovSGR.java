package com.ec.tvcable.switchaprov.AprovSGR;

import com.ec.tvcable.switchaprov.AprovisionamientoSGR.AprovisionamientoResponse;
import com.ec.tvcable.switchaprov.AprovisionamientoSGR.Aprovisionamiento_Type;

public interface AprovSGR {
	
	public AprovisionamientoResponse respuesta (Aprovisionamiento_Type parametros);

}
