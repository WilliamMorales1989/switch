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

import com.ec.tvcable.switchaprov.AprovisionamientoConverterIntraway;
import com.ec.tvcable.switchaprov.AprovisionamientoInterfaces;
import com.ec.tvcable.switchaprov.DatosIntraway;
import com.ec.tvcable.switchaprov.DeviceProcess;
import com.ec.tvcable.switchaprov.InterfaceInvocationResponse;
import com.ec.tvcable.switchaprov.InterfazResolver;
import com.ec.tvcable.switchaprov.IntrawayInterfaceService;
import com.ec.tvcable.switchaprov.Operation;
import com.ec.tvcable.switchaprov.exception.AprovisionamientoException;
import com.ec.tvcable.switchaprov.exception.ConversionException;
import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;
import com.ec.tvcable.switchaprov.jpa.TransactionSpIntraway;
import com.ec.tvcable.switchaprov.service.aprov.Device;
import com.ec.tvcable.switchaprov.service.intraway.Comando;
import com.ec.tvcable.switchaprov.service.intraway.Respuesta;
import com.ec.tvcable.switchaprov.service.intraway.WsdlIntraway;
import com.ec.tvcable.switchaprov.service.intraway.Intraway;
import com.ec.tvcable.switchaprov.service.intraway.Mensaje;


/**
 * @author pablo
 * 
 */
@Service(IntrawayInterfaceService.class)
public class IntrawayInterfaceServiceBean implements IntrawayInterfaceService {

	@Reference 
	@Inject
	WsdlIntraway wsdlIntraway;
	
	@Reference
	@Inject
	private DatosIntraway datosIntraway;

	@Reference
	@Inject
	private InterfazResolver interfazResolver;
	
	private static final Logger logger = Logger.getLogger(IntrawayInterfaceServiceBean.class);

	private Respuesta respuesta;
	private String actualInterface;

	
	@Override
	public List<InterfaceInvocationResponse> invokeInterfaces(AprovisionamientoInterfaces comandoInterfaces) {
		
		List<InterfaceInvocationResponse> responses = new ArrayList<InterfaceInvocationResponse>();
		
		Operation operation = new Operation(comandoInterfaces.getDevice().getSystem(), comandoInterfaces.getDevice().getActivityType());
		
		actualInterface = null;
		try {
			Comando comando = createComando(new DeviceProcess(comandoInterfaces.getDevice().getDeviceId(),
					comandoInterfaces.getAprovisionamientoType().getBodyRequest().getProcessId()));

			List<InterfazAprovisionamiento> interfaces = interfazResolver.resolveInterfaces(operation);

			assignMessageAttributes(comandoInterfaces.getDevice(), comando.getDetalle().getIntraway());

			for (InterfazAprovisionamiento interf : interfaces) {
				actualInterface = interf.getInterfaceCode();
				comando.getCabecera().setInterface(Integer.parseInt(actualInterface));
				respuesta = invokeAprovIntraway(comando);
				responses.add(generateResponseIntraway());
			}

		} catch (ConversionException | AprovisionamientoException| DataQueryException  e) {
			logger.error("Problemas al invocar interfaces: ", e);
			buildFailedResponse(e);
			responses.add(generateResponseIntraway());
			e.printStackTrace();
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

	private void assignMessageAttributes(Device device, Intraway comando) {
		comando.getInterfaz().setMACAddress(device.getSerialNumber());
		//comando.setTipoD(Integer.parseInt(device.getDeviceType()));
		//comando.setIdConvertidor(device.getMacAddress1());
	}

	public void buildFailedResponse(Exception e) {
		respuesta = new Respuesta();
		Mensaje mensaje = new Mensaje();
		// TODO: Definir codigo de erorr
		mensaje.setCodError(100);
		mensaje.setDetMensaje(buildDetailExceptionMessage(e));
		respuesta.setMensaje(mensaje); 
	}

	public Respuesta invokeAprovIntraway(Comando comando) {
		return wsdlIntraway.AprovIntraway(comando);
	}

	@Override
	public InterfaceInvocationResponse generateResponseIntraway() {
		InterfaceInvocationResponse iir = new InterfaceInvocationResponse();
		iir.setInterfaz(actualInterface);
		Mensaje mensaje = respuesta.getMensaje();
		iir.setCodError(mensaje.getCodError());
		iir.setDetMensaje(mensaje.getDetMensaje());
		return iir;
	}

	private Comando createComando(DeviceProcess deviceProcess) throws ConversionException, DataQueryException {
		AprovisionamientoConverterIntraway converter;
		TransactionSpIntraway transactionSpIntraway =  datosIntraway.findByDevice(deviceProcess);
		converter = new AprovisionamientoConverterIntraway(transactionSpIntraway );
		return converter.toComandoIntraway();
	}

}