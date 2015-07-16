package com.ec.tvcable.switchaprov;

import com.ec.tvcable.switchaprov.service.tvconax.ParametrosConax;
import com.ec.tvcable.switchaprov.service.tvconax.RespuestaConax;

public interface Aprov_Conax {

	public RespuestaConax respConax (ParametrosConax paramConax);
}
