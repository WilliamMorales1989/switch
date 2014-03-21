/**
 * 
 */
package com.ec.tvcable.switchaprov.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.AprovisionamientoConverter;
import com.ec.tvcable.switchaprov.ComandoInterfaces;
import com.ec.tvcable.switchaprov.DatosTvPagada;
import com.ec.tvcable.switchaprov.DeviceProcess;
import com.ec.tvcable.switchaprov.InterfaceInvocationResponse;
import com.ec.tvcable.switchaprov.TvInterfaceService;
import com.ec.tvcable.switchaprov.exception.ConversionException;
import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.service.tvpagada.Comando;
import com.ec.tvcable.switchaprov.service.tvpagada.Mensaje;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;
import com.ec.tvcable.switchaprov.service.tvpagada.WsdlTvPagada;

/**
 * @author pablo
 * 
 */
@Service(TvInterfaceService.class)
public class TvInterfazServiceBean implements TvInterfaceService {
	
	@Reference
	@Inject
	private WsdlTvPagada wsdlTvPagada;

	@Reference
	@Inject
	private DatosTvPagada datosTvPagada;

	private static final Logger logger = Logger.getLogger(TvInterfazServiceBean.class);

	private Respuesta respuesta;
	private String actualInterface;

	@Override
	public List<InterfaceInvocationResponse> invokeInterfaces(ComandoInterfaces comandoInterfaces) {
		List<InterfaceInvocationResponse> responses = new ArrayList<InterfaceInvocationResponse>();

		actualInterface = null;
		try {
			Comando comando = createComando(new DeviceProcess(comandoInterfaces.getDevice().getDeviceId(),
					comandoInterfaces.getAprovisionamientoType().getBodyRequest().getProcessId()));
			for (String interf : comandoInterfaces.getInterfaces()) {
				actualInterface = interf;
				comando.getCabecera().setInterface(Integer.parseInt(interf));
				respuesta = invokeAprovTvpagada(comando);
				responses.add(generateResponse());
			}
		} catch (Exception e) {
			logger.error("Problemas al invocar interfaces: ", e);
			genFailedResponse(e);
			responses.add(generateResponse());
		}
		return responses;
	}

	public void genFailedResponse(Exception e) {
		respuesta = new Respuesta();
		Mensaje mensaje = new Mensaje();
		// TODO: Definir codigo de erorr
		mensaje.setCodError(100);
		mensaje.setDetMensaje(e.getMessage());

		respuesta.setMensaje(mensaje);
	}

	public Respuesta invokeAprovTvpagada(Comando comando) {
		return wsdlTvPagada.AprovTvPagada(comando);
	}

	@Override
	public InterfaceInvocationResponse generateResponse() {
		InterfaceInvocationResponse iir = new InterfaceInvocationResponse();
		iir.setInterfaz(actualInterface);
		Mensaje mensaje = respuesta.getMensaje();
		iir.setCodError(mensaje.getCodError());
		iir.setDetMensaje(mensaje.getDetMensaje());

		return iir;
	}

	public Comando createComando(DeviceProcess deviceProcess) throws ConversionException {
		AprovisionamientoConverter converter;
		try {
			converter = new AprovisionamientoConverter(datosTvPagada.findByDevice(deviceProcess));
		} catch (DataQueryException e) {
			throw new ConversionException("Error al consultar datos para transaccion. ".concat(e.getMessage()), e);
		}
		return converter.toComandoTv();
	}

}