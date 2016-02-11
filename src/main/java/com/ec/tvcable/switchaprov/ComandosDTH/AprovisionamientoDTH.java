package com.ec.tvcable.switchaprov.ComandosDTH;

import com.ec.tvcable.switchaprov.AprovisionamientoSGR.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;

public interface AprovisionamientoDTH {
	
	public Respuesta resp (Aprovisionamiento_Type parametros);

}
