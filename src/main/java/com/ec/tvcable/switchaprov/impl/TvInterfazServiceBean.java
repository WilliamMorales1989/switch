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

import com.ec.tvcable.switchaprov.Aprov_Conax;
import com.ec.tvcable.switchaprov.AprovisionamientoConverter;
import com.ec.tvcable.switchaprov.AprovisionamientoInterfaces;
import com.ec.tvcable.switchaprov.DatosTvPagada;
import com.ec.tvcable.switchaprov.DeviceProcess;
import com.ec.tvcable.switchaprov.InterfaceInvocationResponse;
import com.ec.tvcable.switchaprov.InterfazResolver;
import com.ec.tvcable.switchaprov.Operation;
import com.ec.tvcable.switchaprov.TvInterfaceService;
import com.ec.tvcable.switchaprov.exception.AprovisionamientoException;
import com.ec.tvcable.switchaprov.exception.ConversionException;
import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.aprov.BodyRequest;
import com.ec.tvcable.switchaprov.service.aprov.BodyResponse;
import com.ec.tvcable.switchaprov.service.aprov.Device;
import com.ec.tvcable.switchaprov.service.tvpagada.Comando;
import com.ec.tvcable.switchaprov.service.tvpagada.Mensaje;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;
import com.ec.tvcable.switchaprov.service.tvpagada.TVpagada;
import com.ec.tvcable.switchaprov.service.tvpagada.WsdlTvPagada;
import com.ec.tvcable.switchaprov.service.tvconax.Aprov_ConaxBean;
/*import com.ec.tvcable.switchaprov.service.tvconax.DatosServicio;
import com.ec.tvcable.switchaprov.service.tvconax.RespuestaServico;
import com.ec.tvcable.switchaprov.service.tvconax.RespuestaServicoResponse;
import com.thoughtworks.xstream.io.json.JsonWriter.Format;*/
import com.ec.tvcable.switchaprov.service.tvconax.ParametrosConax;


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

	@Reference
	@Inject
	private InterfazResolver interfazResolver;
	
	@Reference
	@Inject
	private Aprov_Conax aprov_Conax;
	
		
	private static final Logger logger = Logger.getLogger(TvInterfazServiceBean.class);

	private Respuesta respuesta;
	private String actualInterface;
	/* (non-Javadoc)
	 * @see com.ec.tvcable.switchaprov.TvInterfaceService#invokeInterfaces(com.ec.tvcable.switchaprov.AprovisionamientoInterfaces)
	 */
	@Override
	public List<InterfaceInvocationResponse> invokeInterfaces(AprovisionamientoInterfaces comandoInterfaces)
			throws DataQueryException {

			
		List<InterfaceInvocationResponse> responses = new ArrayList<InterfaceInvocationResponse>();

		Operation operation = new Operation(comandoInterfaces.getDevice().getSystem(), comandoInterfaces.getDevice().getActivityType());
		
		actualInterface = null;
		try {
			Comando comando = createComando(new DeviceProcess(comandoInterfaces.getDevice().getDeviceId(),
					comandoInterfaces.getAprovisionamientoType().getBodyRequest().getProcessId()));
			
			
			/************************************************************************************************/
			System.out.println(comandoInterfaces.getDevice().getController());
			
			if (comandoInterfaces.getDevice().getController().equals("Conax")){
			
				ParametrosConax paramConax = new ParametrosConax();
				
				paramConax.setActivity(comandoInterfaces.getDevice().getActivityType());
				paramConax.setCitem_id(Integer.parseInt(comandoInterfaces.getDevice().getDeviceId()));
				paramConax.setProcess_id(Integer.parseInt(comandoInterfaces.getAprovisionamientoType().getBodyRequest().getProcessId()));
				paramConax.setSerial(comandoInterfaces.getDevice().getSerialNumber());
				
				aprov_Conax.respConax(paramConax);
				
				
				
				/*DatosServicio consultaDatos = crearDatosServicio(comandoInterfaces);
				
				RespuestaServicoConax respuestaConax = wsdlaprov_conaxPortType.respuestaServico(consultaDatos);
				
				/*DatosServicio datosservicio = new DatosServicio();
				
				datosservicio.setActivity(comandoInterfaces.getDevice().getActivityType());
				datosservicio.setCitemId(Integer.parseInt(comandoInterfaces.getDevice().getDeviceId()));
				datosservicio.setProcessId(Integer.parseInt(comandoInterfaces.getAprovisionamientoType().getBodyRequest().getProcessId()));
				datosservicio.setSerial(comandoInterfaces.getDevice().getSerialNumber());
				
				//wsdlaprov_conaxPortType.respuestaServico(datosservicio);
				invokeDatosConax(datosservicio);*/
				
			}
				else {
				
					List<InterfazAprovisionamiento> interfaces = interfazResolver.resolveInterfaces(operation);

					assignMessageAttributes(comandoInterfaces.getDevice(), comando.getDetalle().getTVpagada());

					for (InterfazAprovisionamiento interf : interfaces) {
						actualInterface = interf.getInterfaceCode();
						comando.getCabecera().setInterface(Integer.parseInt(actualInterface));
						comando.getDetalle().getTVpagada().setAccion(interf.getAccion());
						respuesta = invokeAprovTvpagada(comando);
						responses.add(generateResponse());
					}
			}
			
			
		} catch (ConversionException | AprovisionamientoException e) {
			logger.error("Problemas al invocar interfaces: ", e);
			buildFailedResponse(e);
			responses.add(generateResponse());
		}
		return responses;
	}

	/***********************************************************************************************/
		
	/*private DatosServicio crearDatosServicio(
			 AprovisionamientoInterfaces comandoInterfaces) {
		DatosServicio aprovConax = new DatosServicio();
		
		aprovConax.setActivity(aprovConax.getActivity());
		aprovConax.setCitemId(aprovConax.getCitemId());
		aprovConax.setProcessId(aprovConax.getProcessId());
		aprovConax.setSerial(aprovConax.getSerial());
		
		return aprovConax;
	}
	
	
	
	public RespuestaServicoConax invokeDatosConax(DatosServicio datosServicio) {
		return wsdlaprov_conaxPortType.respuestaServico(datosServicio);
	}*/
	/************************************************************************************************/
	
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

	private Comando createComando(DeviceProcess deviceProcess) throws ConversionException, DataQueryException {
		AprovisionamientoConverter converter;
		converter = new AprovisionamientoConverter(datosTvPagada.findByDevice(deviceProcess));
		return converter.toComandoTv();
	}

	
}