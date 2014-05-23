/**
 * 
 */
package com.ec.tvcable.switchaprov.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.NoRouteToHostException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import com.ec.tvcable.switchaprov.AprovisionamientoBean;
import com.ec.tvcable.switchaprov.AprovisionamientoInterfaces;
import com.ec.tvcable.switchaprov.DatosTvPagada;
import com.ec.tvcable.switchaprov.DeviceProcess;
import com.ec.tvcable.switchaprov.InterfazResolver;
import com.ec.tvcable.switchaprov.Operation;
import com.ec.tvcable.switchaprov.TransactionSpResponseService;
import com.ec.tvcable.switchaprov.TvInterfaceService;
import com.ec.tvcable.switchaprov.exception.AprovisionamientoException;
import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.impl.TvInterfazServiceBean;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;
import com.ec.tvcable.switchaprov.jpa.TransactionHeaderResponse;
import com.ec.tvcable.switchaprov.jpa.TransactionSpTvPagada;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento;
import com.ec.tvcable.switchaprov.service.aprov.AprovisionamientoResponse;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.tvpagada.Cabecera;
import com.ec.tvcable.switchaprov.service.tvpagada.Comando;
import com.ec.tvcable.switchaprov.service.tvpagada.Mensaje;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;
import com.ec.tvcable.switchaprov.service.tvpagada.WsdlTvPagada;

/**
 * @author pablo
 * 
 */
public class MockTest extends BaseTest {

	private DatosTvPagada datosTvPagada;
	private Aprovisionamiento aprovisionamiento;
	private WsdlTvPagada wsdlTvPagada;
	private TvInterfaceService tvInterfaceService;
	private TvInterfaceService tvInterfaceServiceSpy;
	private InterfazResolver resolver;
	private Aprovisionamiento_Type requestMessage;
	private TransactionSpResponseService transactionResponseService;

	@Before
	public void init() {
		aprovisionamiento = new AprovisionamientoBean();
		datosTvPagada = mock(DatosTvPagada.class);
		wsdlTvPagada = mock(WsdlTvPagada.class);
		transactionResponseService = mock(TransactionSpResponseService.class);
		resolver = mock(InterfazResolver.class);

		tvInterfaceService = new TvInterfazServiceBean();
		tvInterfaceServiceSpy = Mockito.spy(tvInterfaceService);

		Whitebox.setInternalState(tvInterfaceServiceSpy, "wsdlTvPagada", wsdlTvPagada);
		Whitebox.setInternalState(tvInterfaceServiceSpy, "datosTvPagada", datosTvPagada);
		Whitebox.setInternalState(tvInterfaceServiceSpy, "interfazResolver", resolver);

		Whitebox.setInternalState(aprovisionamiento, "tvInterfaceService", tvInterfaceServiceSpy);
		Whitebox.setInternalState(aprovisionamiento, "transactionResponseService", transactionResponseService);

		requestMessage = createAprovisionamientotype();
	}

	@Test
	public void ejecucionFallidaSiNoHaySystem() {
		addDeviceToRequest(requestMessage, "1", "activity", "serialnumber", "tvpagada");
		requestMessage.getHeaderRequest().setTarget("");

		AprovisionamientoResponse response = aprovisionamiento.aprovisionamientoResp(requestMessage);

		Assert.assertTrue(response.getBodyResponse().getResponseMessage()
				.contains("No existe implementacion para el SYSTEM: tvpagada"));

	}

	@Test
	public void invocarDeAcuerdoConSystem() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber", "TV");
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("702"));
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());

			aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(AprovisionamientoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy).generateResponse();

		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void debeIterarPorDevicesEInterfaces() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber", "TV");
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("702"));
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());

			aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(AprovisionamientoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy).generateResponse();

		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void ejecucionFallidaSiNoHayInterfaces() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serial-123", "TV");

			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenThrow(
					new AprovisionamientoException("No existen interfaces definidas para system: ? activityType ?"));
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);

			AprovisionamientoResponse response = aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(transactionResponseService).saveHeader(any(TransactionHeaderResponse.class));

			Assert.assertEquals("Device: serial-123 No existen interfaces definidas para system: ? activityType ?",
					response.getBodyResponse().getResponseMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void mostrarDetalleSiMediadorNoDisponible() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serial-123", "TV");

			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("100"));
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenThrow(
					new RuntimeException(new NoRouteToHostException("Servicio no disponible")));

			AprovisionamientoResponse response = aprovisionamiento.aprovisionamientoResp(requestMessage);

			Assert.assertTrue(response.getBodyResponse().getResponseMessage()
					.contains("java.net.NoRouteToHostException: Servicio no disponible"));
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void debeRetornarErrorDeConversion() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serial-123", "TV");
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();
			transactionSpTvPagada.setNegocio("");

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("702"));
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);

			AprovisionamientoResponse response = aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(tvInterfaceServiceSpy).invokeInterfaces(any(AprovisionamientoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy).generateResponse();

			Assert.assertEquals(
					"Device: serial-123 Error de conversion de datos para el campo [Negocio]For input string: \"\"",
					response.getBodyResponse().getResponseMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void errorSiRegistroNoEsValido() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber", "TV");
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();
			transactionSpTvPagada.setIsValid("F");

			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("702"));

			AprovisionamientoResponse emsResponse = aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(tvInterfaceServiceSpy).invokeInterfaces(any(AprovisionamientoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy).generateResponse();

			Assert.assertEquals("Device: serialnumber El registro de datos esta marcado como invalido", emsResponse
					.getBodyResponse().getResponseMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void errorNoValidoEnSegundoDevice() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber_1", "TV");
			addDeviceToRequest(requestMessage, "2", "activity", "serialnumber_2", "TV");

			TransactionSpTvPagada tvPagada1 = createDatosTvPagada();
			TransactionSpTvPagada tvPagada2 = createDatosTvPagada();
			tvPagada2.setIsValid("F");

			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(tvPagada1).thenReturn(tvPagada2);
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("702"));

			AprovisionamientoResponse emsResponse = aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(resolver, times(1)).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy, times(2)).invokeInterfaces(any(AprovisionamientoInterfaces.class));
			verify(datosTvPagada, times(2)).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy, times(2)).generateResponse();

			Assert.assertEquals("Device: serialnumber_2 El registro de datos esta marcado como invalido", emsResponse
					.getBodyResponse().getResponseMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void errorNoHayRegistroDeDatosPrimerDevice() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber_1", "TV");

			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenThrow(
					new DataQueryException("No existen datos para el device 1 process 1"));

			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("702"));

			AprovisionamientoResponse emsResponse = aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(tvInterfaceServiceSpy, times(1)).invokeInterfaces(any(AprovisionamientoInterfaces.class));
			verify(datosTvPagada, times(1)).findByDevice(any(DeviceProcess.class));
			verify(transactionResponseService, times(1)).saveHeader(any(TransactionHeaderResponse.class));

			Assert.assertTrue(emsResponse.getBodyResponse().getResponseMessage()
					.contains("No existen datos para el device 1 process 1"));
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void errorSiNoHayRegistroDeDatosEnSegundoDevice() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber_1", "TV");
			addDeviceToRequest(requestMessage, "2", "activity", "serialnumber_2", "TV");

			TransactionSpTvPagada tvPagada = createDatosTvPagada();

			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(tvPagada).thenThrow(
					new DataQueryException("No existen datos para el device 1 process 1"));

			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("702"));

			AprovisionamientoResponse emsResponse = aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(resolver, times(1)).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy, times(2)).invokeInterfaces(any(AprovisionamientoInterfaces.class));
			verify(datosTvPagada, times(2)).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy, times(1)).generateResponse();
			verify(transactionResponseService, times(1)).saveHeader(any(TransactionHeaderResponse.class));

			Assert.assertTrue(emsResponse.getBodyResponse().getResponseMessage()
					.contains("No existen datos para el device 1 process 1"));
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void errorEnSegundaInterfaz() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serie-123", "TV");
			TransactionSpTvPagada createDatosTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("702", "600", "500"));
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse())
					.thenReturn(createTvPagadaErorrResponse()).thenReturn(createTvPagadaSuccessResponse());
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(createDatosTvPagada);

			AprovisionamientoResponse emsResponse = aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(AprovisionamientoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy, Mockito.times(3)).generateResponse();
			verify(tvInterfaceServiceSpy, Mockito.times(3)).invokeAprovTvpagada(any(Comando.class));
			verify(transactionResponseService).saveHeader(any(TransactionHeaderResponse.class));

			Assert.assertEquals("Device: serie-123 (I: 600) Error de ejecucion", emsResponse.getBodyResponse()
					.getResponseMessage());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void ejecucionExitosaUnDispositivo() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serie-123", "TV");
			TransactionSpTvPagada createDatosTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(buildInterfaceStub("702", "600", "500"));
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(createDatosTvPagada);

			AprovisionamientoResponse emsResponse = aprovisionamiento.aprovisionamientoResp(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(AprovisionamientoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy, times(3)).generateResponse();
			verify(tvInterfaceServiceSpy, times(3)).invokeAprovTvpagada(any(Comando.class));
			verify(transactionResponseService).saveHeader(any(TransactionHeaderResponse.class));

			Assert.assertEquals(0, emsResponse.getBodyResponse().getResponseCode());
			Assert.assertTrue("El mensaje de error debe estar vacio", emsResponse.getBodyResponse()
					.getResponseMessage().isEmpty());
		} catch (DataQueryException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (AprovisionamientoException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	private Respuesta createTvPagadaErorrResponse() {
		Respuesta respuesta = createTvPagadaResponse();
		respuesta.getMensaje().setCodError(0);
		respuesta.getMensaje().setDetMensaje("Error de ejecucion");
		return respuesta;
	}

	private Respuesta createTvPagadaSuccessResponse() {
		Respuesta respuesta = createTvPagadaResponse();
		respuesta.getMensaje().setCodError(1);
		respuesta.getMensaje().setDetMensaje("Ejecucion exitosa");
		return respuesta;
	}

	private Respuesta createTvPagadaResponse() {
		Respuesta respuesta = new Respuesta();
		Cabecera cabecera = new Cabecera();
		cabecera.setIDEmpresa(1);
		respuesta.setCabecera(cabecera);
		Mensaje mensaje = new Mensaje();
		mensaje.setDetMensaje("Ejecucion exitosa");
		respuesta.setMensaje(mensaje);
		return respuesta;
	}

	private List<InterfazAprovisionamiento> buildInterfaceStub(String... lista) {
		List<InterfazAprovisionamiento> interfaces = new ArrayList<InterfazAprovisionamiento>();

		for (int i = 0; i < lista.length; i++) {
			InterfazAprovisionamiento ia = new InterfazAprovisionamiento();
			ia.setInterfaceCode(lista[i]);
			ia.setAccion(1);
			interfaces.add(ia);
			ia.setSystem("TV");
		}

		return interfaces;
	}

}