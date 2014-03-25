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
import com.ec.tvcable.switchaprov.AprovisionamientoInterfaces;
import com.ec.tvcable.switchaprov.DatosTvPagada;
import com.ec.tvcable.switchaprov.DeviceProcess;
import com.ec.tvcable.switchaprov.InterfaceInvocationResponse;
import com.ec.tvcable.switchaprov.TvInterfaceService;
import com.ec.tvcable.switchaprov.exception.ConversionException;
import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;
import com.ec.tvcable.switchaprov.service.aprov.Device;
import com.ec.tvcable.switchaprov.service.tvpagada.Comando;
import com.ec.tvcable.switchaprov.service.tvpagada.Mensaje;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;
import com.ec.tvcable.switchaprov.service.tvpagada.TVpagada;
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
	public List<InterfaceInvocationResponse> invokeInterfaces(AprovisionamientoInterfaces comandoInterfaces) {
		List<InterfaceInvocationResponse> responses = new ArrayList<InterfaceInvocationResponse>();

		actualInterface = null;
		try {

			Comando comando = createComando(new DeviceProcess(comandoInterfaces.getDevice().getDeviceId(),
					comandoInterfaces.getAprovisionamientoType().getBodyRequest().getProcessId()));

			assignMessageAttributes(comandoInterfaces.getDevice(), comando.getDetalle().getTVpagada());

			for (InterfazAprovisionamiento interf : comandoInterfaces.getInterfaces()) {
				actualInterface = interf.getInterfaceCode();
				comando.getCabecera().setInterface(Integer.parseInt(actualInterface));
				comando.getDetalle().getTVpagada().setAccion(interf.getAccion());
				respuesta = invokeAprovTvpagada(comando);
				responses.add(generateResponse());
			}

		} catch (Exception e) {
			logger.error("Problemas al invocar interfaces: ", e);
			buildFailedResponse(e);
			responses.add(generateResponse());
		}
		return responses;
	}

	private String buildDetailExceptionMessage(Throwable e) {
		StringBuilder sb = new StringBuilder(120);

		Throwable exception = e;

		while (exception != null) {
			sb.append(exception.getMessage());
			exception = exception.getCause();
		}
		return sb.toString();
	}

	private void assignMessageAttributes(Device device, TVpagada comando) {
		comando.setSerie(device.getSerialNumber());
		comando.setTipoD(Integer.parseInt(device.getDeviceType()));
		comando.setIdConvertidor(device.getMacAddress1());
	}

	public void buildFailedResponse(Exception e) {
		respuesta = new Respuesta();
		Mensaje mensaje = new Mensaje();
		// TODO: Definir codigo de erorr
		mensaje.setCodError(100);
		mensaje.setDetMensaje(buildDetailExceptionMessage(e));
		System.out.println("mensaje en respuesta: " + mensaje.getDetMensaje());
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
		System.out.println("mensaje en iir: " + mensaje.getDetMensaje());
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