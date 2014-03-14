/**
 * 
 */
package com.ec.tvcable.switch_aprov.servicio.ems;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import com.ec.tvcable.switch_aprov.ComandoEmsInterfaces;
import com.ec.tvcable.switch_aprov.DatosTvPagada;
import com.ec.tvcable.switch_aprov.EMSBean;
import com.ec.tvcable.switch_aprov.InterfazResolver;
import com.ec.tvcable.switch_aprov.Operation;
import com.ec.tvcable.switch_aprov.TransactionResponseService;
import com.ec.tvcable.switch_aprov.TvInterfaceService;
import com.ec.tvcable.switch_aprov.exception.DataQueryException;
import com.ec.tvcable.switch_aprov.impl.TvInterfazServiceBean;
import com.ec.tvcable.switch_aprov.jpa.TransactionSpTvPagada;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Cabecera;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Comando;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Mensaje;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.Respuesta;
import com.ec.tvcable.switch_aprov.servicio.tvpagada.WsdlTvPagada;

/**
 * @author pablo
 * 
 */
public class MockTest {

	private DatosTvPagada datosTvPagada;
	private EMS ems;
	private WsdlTvPagada wsdlTvPagada;
	private TvInterfaceService tvInterfaceService;
	private TvInterfaceService tvInterfaceServiceSpy;
	private InterfazResolver resolver;
	private EMS_Type requestMessage;
	private TransactionResponseService transactionResponseService;

	@Before
	public void init() {
		ems = new EMSBean();
		datosTvPagada = mock(DatosTvPagada.class);
		wsdlTvPagada = mock(WsdlTvPagada.class);
		transactionResponseService = mock(TransactionResponseService.class);

		tvInterfaceService = new TvInterfazServiceBean();
		tvInterfaceServiceSpy = Mockito.spy(tvInterfaceService);

		Whitebox.setInternalState(tvInterfaceServiceSpy, "wsdlTvPagada", wsdlTvPagada);
		Whitebox.setInternalState(tvInterfaceServiceSpy, "datosTvPagada", datosTvPagada);

		Whitebox.setInternalState(ems, "tvInterfaceService", tvInterfaceServiceSpy);
		Whitebox.setInternalState(ems, "transactionResponseService", transactionResponseService);

		resolver = mock(InterfazResolver.class);
		Whitebox.setInternalState(ems, "interfazResolver", resolver);

		requestMessage = createEMSMessage();
	}

	@Test
	public void debeDarErrorDeConversion() {
		try {
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();
			transactionSpTvPagada.setNegocio("");

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));
			when(datosTvPagada.findByDevice(Mockito.anyString())).thenReturn(transactionSpTvPagada);

			EMSResponse emsResponse = ems.EMS(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoEmsInterfaces.class));
			verify(datosTvPagada).findByDevice(requestMessage.getBody().getProcessId());
			verify(tvInterfaceServiceSpy).generateResponse();

			Assert.assertEquals("Error de conversion de datos para el campo [Negocio]", emsResponse.getErrorMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void debeDarErrorDeDatosVacio() {
		try {
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();
			transactionSpTvPagada.setAnyTime(null);

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));
			when(datosTvPagada.findByDevice(Mockito.anyString())).thenReturn(transactionSpTvPagada);

			EMSResponse emsResponse = ems.EMS(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoEmsInterfaces.class));
			verify(datosTvPagada).findByDevice(requestMessage.getBody().getProcessId());
			verify(tvInterfaceServiceSpy).generateResponse();

			Assert.assertEquals("Dato vacio para el campo [AnyTime]", emsResponse.getErrorMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void errorSiRegistroNoEsValido() {
		try {
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();
			transactionSpTvPagada.setIsValid("F");

			when(datosTvPagada.findByDevice(Mockito.anyString())).thenReturn(transactionSpTvPagada);
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));

			EMSResponse emsResponse = ems.EMS(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoEmsInterfaces.class));
			verify(datosTvPagada).findByDevice(requestMessage.getBody().getProcessId());
			verify(tvInterfaceServiceSpy).generateResponse();

			Assert.assertEquals("El registro de datos esta marcado cono invalido", emsResponse.getErrorMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void errorSiNoHayRegistroDeDatos() {
		try {

			when(datosTvPagada.findByDevice(Mockito.anyString())).thenThrow(
					new DataQueryException("No existen datos para el device 1"));

			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));

			EMSResponse emsResponse = ems.EMS(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoEmsInterfaces.class));
			verify(datosTvPagada).findByDevice(requestMessage.getBody().getProcessId());
			verify(tvInterfaceServiceSpy).generateResponse();

			Assert.assertEquals("No existen datos para el device 1", emsResponse.getErrorMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void ejecutarUnaInterfaz() {
		try {
			TransactionSpTvPagada createDatosTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(datosTvPagada.findByDevice(Mockito.anyString())).thenReturn(createDatosTvPagada);

			EMSResponse emsResponse = ems.EMS(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoEmsInterfaces.class));
			verify(datosTvPagada).findByDevice(requestMessage.getBody().getProcessId());
			verify(tvInterfaceServiceSpy).generateResponse();

			Assert.assertEquals("Interfaz 702: Ejecucion exitosa |", emsResponse.getErrorMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void errorEnSegundaInterfaz() {
		try {
			TransactionSpTvPagada createDatosTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702", "600", "500"));
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse()).thenReturn(createTvPagadaErorrResponse());
			when(datosTvPagada.findByDevice(Mockito.anyString())).thenReturn(createDatosTvPagada);

			EMSResponse emsResponse = ems.EMS(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoEmsInterfaces.class));
			verify(datosTvPagada).findByDevice(requestMessage.getBody().getProcessId());
			verify(tvInterfaceServiceSpy, Mockito.times(2)).generateResponse();
			verify(tvInterfaceServiceSpy, Mockito.times(2)).invokeAprovTvpagada(any(Comando.class));

			Assert.assertEquals("Interfaz 702: Ejecucion exitosa |Interfaz 600: Error de ejecucion |", emsResponse.getErrorMessage());
		} catch (DataQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private TransactionSpTvPagada createDatosTvPagada() {
		TransactionSpTvPagada transactionSpTvPagada = new TransactionSpTvPagada();
		transactionSpTvPagada.setId(1l);
		transactionSpTvPagada.setDeviceId(1l);
		transactionSpTvPagada.setIdEmpresa(1l);
		transactionSpTvPagada.setNegocio("1");
		transactionSpTvPagada.setSecuencia(1l);
		transactionSpTvPagada.setSerie("1");
		transactionSpTvPagada.setTipoD(1l);
		transactionSpTvPagada.setIdConvertidor("1");
		transactionSpTvPagada.setIdAccount(1l);
		transactionSpTvPagada.setcItem(1l);
		transactionSpTvPagada.setUbicacion(1l);
		transactionSpTvPagada.setAccion(1l);
		transactionSpTvPagada.setCredito(1l);
		transactionSpTvPagada.setIdServicio(1l);
		transactionSpTvPagada.setIdPaquetes("1");
		transactionSpTvPagada.setIdEventos("1");
		transactionSpTvPagada.setTipoA(1l);
		transactionSpTvPagada.setEstadoC("1");
		transactionSpTvPagada.setFormaPago("1");
		transactionSpTvPagada.setTipoC("1");
		transactionSpTvPagada.setTipoPromocion("1");
		transactionSpTvPagada.setDatoC1("1");
		transactionSpTvPagada.setDatoC2("1");
		transactionSpTvPagada.setCodigoCanal("1");
		transactionSpTvPagada.setDescEvento("1");
		transactionSpTvPagada.setComienzoEventoTiempoIni(new Date());
		transactionSpTvPagada.setFinalEventoFechaFin(new Date());
		transactionSpTvPagada.setComienzoEventoTiempoIni(new Date());
		transactionSpTvPagada.setDuracionEvento(1l);
		transactionSpTvPagada.setInterstitial("1");
		transactionSpTvPagada.setTiempoLibre("1");
		transactionSpTvPagada.setMpaa("1");
		transactionSpTvPagada.setContenidoViolento("1");
		transactionSpTvPagada.setContenidoSexual("1");
		transactionSpTvPagada.setLenguaje("1");
		transactionSpTvPagada.setRating("1");
		transactionSpTvPagada.setTiempoCompra("1");
		transactionSpTvPagada.setPaquete("1");
		transactionSpTvPagada.setTiempoDisplay("1");
		transactionSpTvPagada.setCostoEvento("1");
		transactionSpTvPagada.setPrecioEvento("1");
		transactionSpTvPagada.setAnyTime("1");
		transactionSpTvPagada.setIsValid("Y");
		transactionSpTvPagada.setDfrom(new Date());
		transactionSpTvPagada.setDto(new Date());
		return transactionSpTvPagada;
	}

	private Respuesta createTvPagadaErorrResponse() {
		Respuesta respuesta = createTvPagadaResponse();
		respuesta.getMensaje().setCodError(1);
		respuesta.getMensaje().setDetMensaje("Error de ejecucion");
		return respuesta;
	}


	private Respuesta createTvPagadaSuccessResponse() {
		Respuesta respuesta = createTvPagadaResponse();
		respuesta.getMensaje().setDetMensaje("Ejecucion exitosa");
		return respuesta;
	}
	
	private Respuesta createTvPagadaResponse() {
		Respuesta respuesta = new Respuesta();
		Cabecera cabecera = new Cabecera();
		cabecera.setIDEmpresa(1);
		respuesta.setCabecera(cabecera);
		Mensaje mensaje = new Mensaje();
		mensaje.setCodError(0);
		mensaje.setDetMensaje("Ejecucion exitosa");
		respuesta.setMensaje(mensaje);
		return respuesta;
	}
	
	

	private EMS_Type createEMSMessage() {
		EMS_Type message = new EMS_Type();
		Header header = new Header();
		header.setTarget("TV");
		message.setHeader(header);

		Body body = new Body();
		body.setProcessId("1");
		message.setBody(body);

		return message;
	}

	private List<String> createInterfaceStub(String... lista) {
		List<String> interfaces = new ArrayList<String>();

		for (int i = 0; i < lista.length; i++) {
			interfaces.add(lista[i]);
		}

		return interfaces;
	}

}
