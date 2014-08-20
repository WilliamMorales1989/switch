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
import com.ec.tvcable.switchaprov.JaxbConverter;
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
	private int accion;
	private Long emtaCitemId;
	private boolean provisioningEmta;
	private String telfFlag = new String("TELF");
	private String terminateFlag = new String("TERMINATE");

	
	@Override
	public List<InterfaceInvocationResponse> invokeInterfaces(AprovisionamientoInterfaces comandoInterfaces) {
		
		List<InterfaceInvocationResponse> responses = new ArrayList<InterfaceInvocationResponse>();
		
		Operation operation = new Operation(comandoInterfaces.getDevice().getSystem(), comandoInterfaces.getDevice().getActivityType());
		
		try {
		
			List<InterfazAprovisionamiento> interfaces = interfazResolver.resolveInterfaces(operation);

			for (InterfazAprovisionamiento interf : interfaces) {
				actualInterface = null;
				Comando comando;
				
				try{
					comando = createComando(new DeviceProcess(comandoInterfaces.getDevice().getDeviceId(),
						comandoInterfaces.getAprovisionamientoType().getBodyRequest().getProcessId(), interf.getInterfaceCode() ));
				}
				catch(DataQueryException e){
					comando = createComando(new DeviceProcess(comandoInterfaces.getDevice().getDeviceId(),
							comandoInterfaces.getAprovisionamientoType().getBodyRequest().getProcessId(), "0" ));
				}
				
				defineProvisioningEmta();
				assignMessageAttributes(comandoInterfaces.getDevice(), comando.getDetalle().getIntraway());
				
				actualInterface = interf.getInterfaceCode();
				accion = interf.getAccion();
				comando.getCabecera().setInterface(Integer.parseInt(actualInterface));
				comando.getDetalle().getIntraway().getEstandar().setIdEstado(accion);
			
				System.out.println("request Internet:");
				System.out.println(JaxbConverter.objectToXMLString((comando)));
				
				respuesta = invokeAprovIntraway(comando);
				
				System.out.println("response Internet:");
				System.out.println(JaxbConverter.objectToXMLString((respuesta)));
				
				responses.add(generateResponseIntraway());
				
				if (provisioningEmta){
					System.out.println("Aprovisionamiento Emta:"+String.valueOf(emtaCitemId));
					comandoInterfaces.getDevice().setDeviceId(String.valueOf(emtaCitemId));
					comandoInterfaces.getDevice().setSystem(telfFlag);
					responses.addAll((List<InterfaceInvocationResponse>) invokeInterfaces(comandoInterfaces));
				}
				
			}

		} catch (ConversionException | AprovisionamientoException| DataQueryException  e) {
			logger.error("Problemas al invocar interfaces: ", e);
			buildFailedResponse(e);
			responses.add(generateResponseIntraway());
			e.printStackTrace();
		}
		return responses;
	}
	
	private void defineProvisioningEmta(){
		try{
			if (emtaCitemId > 0)
				provisioningEmta = true;
			else
				provisioningEmta = false;
		}
		catch(NullPointerException e){
			provisioningEmta = false;
		}
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
		
		if (device.getActivityType().equals(terminateFlag) )
			comando.getInterfaz().setMACAddress("");
		else
			if (device.getSystem().equals(telfFlag))	
				comando.getInterfaz().setMACAddress(device.getMacAddress2());
			else
				comando.getInterfaz().setMACAddress(device.getMacAddress1());
		comando.getInterfaz().setMtaModelCRMId(device.getDeviceType());
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
		emtaCitemId = transactionSpIntraway.getEmtaCitemId();
		return converter.toComandoIntraway();
	}

}