/**
 * 
 */
package com.ec.tvcable.switchaprov.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import com.ec.tvcable.switchaprov.AprovisionamientoBean;
import com.ec.tvcable.switchaprov.ComandoInterfaces;
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
import com.ec.tvcable.switchaprov.jpa.TransactionSpResponse;
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

		tvInterfaceService = new TvInterfazServiceBean();
		tvInterfaceServiceSpy = Mockito.spy(tvInterfaceService);

		Whitebox.setInternalState(tvInterfaceServiceSpy, "wsdlTvPagada", wsdlTvPagada);
		Whitebox.setInternalState(tvInterfaceServiceSpy, "datosTvPagada", datosTvPagada);

		Whitebox.setInternalState(aprovisionamiento, "tvInterfaceService", tvInterfaceServiceSpy);
		Whitebox.setInternalState(aprovisionamiento, "transactionResponseService", transactionResponseService);

		resolver = mock(InterfazResolver.class);
		Whitebox.setInternalState(aprovisionamiento, "interfazResolver", resolver);

		requestMessage = createAprovisionamientotype();
	}

	// @Test
	public void capturarErrorInesperado() {

		addDeviceToRequest(requestMessage, "1", "activity", "serialnumber");
		requestMessage.setBodyRequest(null);

		AprovisionamientoResponse response = aprovisionamiento.Aprovisionamiento(requestMessage);

		Assert.assertEquals("Erorr inesperado", response.getBodyResponse().getResponseMessage());
		Assert.assertEquals(0, response.getBodyResponse().getResponseCode());

	}

	@Test
	public void excepcionSiNoHayTarget() {
		addDeviceToRequest(requestMessage, "1", "activity", "serialnumber");
		requestMessage.getHeaderRequest().setTarget("");

		AprovisionamientoResponse response = aprovisionamiento.Aprovisionamiento(requestMessage);

		Assert.assertEquals(
				"Error general de ejecucion: class java.lang.RuntimeException No existe implementacion para el TARGET: ",
				response.getBodyResponse().getResponseMessage());

	}

	@Test
	public void debeIterarPorDevicesEInterfaces() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber");
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());

			AprovisionamientoResponse response = aprovisionamiento.Aprovisionamiento(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy).generateResponse();

			Assert.assertEquals(1, response.getBodyResponse().getDevices().size());
			Assert.assertEquals(1, response.getBodyResponse().getDevices().get(0).getDeviceId());
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
			addDeviceToRequest(requestMessage, "1", "activity", "serial-123");

			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenThrow(
					new AprovisionamientoException("No existen interfaces definidas para system: ? activityType ?"));
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);

			AprovisionamientoResponse response = aprovisionamiento.Aprovisionamiento(requestMessage);

			Assert.assertEquals("Device: serial-123 No existen interfaces definidas para system: ? activityType ?", response
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
	public void debeRetornarErrorDeConversion() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serial-123");
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();
			transactionSpTvPagada.setNegocio("");

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);

			AprovisionamientoResponse response = aprovisionamiento.Aprovisionamiento(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy).generateResponse();

			Assert.assertEquals("Device: serial-123 Error de conversion de datos para el campo [Negocio]", response
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
	public void errorSiRegistroNoEsValido() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber");
			TransactionSpTvPagada transactionSpTvPagada = createDatosTvPagada();
			transactionSpTvPagada.setIsValid("F");

			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(transactionSpTvPagada);
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));

			AprovisionamientoResponse emsResponse = aprovisionamiento.Aprovisionamiento(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoInterfaces.class));
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
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber_1");
			addDeviceToRequest(requestMessage, "2", "activity", "serialnumber_2");

			TransactionSpTvPagada tvPagada1 = createDatosTvPagada();
			TransactionSpTvPagada tvPagada2 = createDatosTvPagada();
			tvPagada2.setIsValid("F");

			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(tvPagada1).thenReturn(tvPagada2);
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));

			AprovisionamientoResponse emsResponse = aprovisionamiento.Aprovisionamiento(requestMessage);

			verify(resolver, times(2)).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy, times(2)).invokeInterfaces(any(ComandoInterfaces.class));
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
	public void errorSiNoHayRegistroDeDatosEnSegundoDevice() {
		try {
			addDeviceToRequest(requestMessage, "1", "activity", "serialnumber_1");
			addDeviceToRequest(requestMessage, "2", "activity", "serialnumber_2");

			TransactionSpTvPagada tvPagada = createDatosTvPagada();

			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(tvPagada).thenThrow(
					new DataQueryException("No existen datos para el device 1"));

			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702"));

			AprovisionamientoResponse emsResponse = aprovisionamiento.Aprovisionamiento(requestMessage);

			verify(resolver, times(2)).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy, times(2)).invokeInterfaces(any(ComandoInterfaces.class));
			verify(datosTvPagada, times(2)).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy, times(2)).generateResponse();

			Assert.assertEquals(
					"Device: serialnumber_2 Error al consultar datos para transaccion. No existen datos para el device 1",
					emsResponse.getBodyResponse().getResponseMessage());
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
			addDeviceToRequest(requestMessage, "1", "activity", "serie-123");
			TransactionSpTvPagada createDatosTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702", "600", "500"));
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse())
					.thenReturn(createTvPagadaErorrResponse()).thenReturn(createTvPagadaSuccessResponse());
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(createDatosTvPagada);

			AprovisionamientoResponse emsResponse = aprovisionamiento.Aprovisionamiento(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy, Mockito.times(3)).generateResponse();
			verify(tvInterfaceServiceSpy, Mockito.times(3)).invokeAprovTvpagada(any(Comando.class));

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
			addDeviceToRequest(requestMessage, "1", "activity", "serie-123");
			TransactionSpTvPagada createDatosTvPagada = createDatosTvPagada();

			when(resolver.resolveInterfaces(any(Operation.class))).thenReturn(createInterfaceStub("702", "600", "500"));
			when(wsdlTvPagada.AprovTvPagada(any(Comando.class))).thenReturn(createTvPagadaSuccessResponse());
			when(datosTvPagada.findByDevice(any(DeviceProcess.class))).thenReturn(createDatosTvPagada);

			AprovisionamientoResponse emsResponse = aprovisionamiento.Aprovisionamiento(requestMessage);

			verify(resolver).resolveInterfaces(any(Operation.class));
			verify(tvInterfaceServiceSpy).invokeInterfaces(any(ComandoInterfaces.class));
			verify(datosTvPagada).findByDevice(any(DeviceProcess.class));
			verify(tvInterfaceServiceSpy, Mockito.times(3)).generateResponse();
			verify(tvInterfaceServiceSpy, Mockito.times(3)).invokeAprovTvpagada(any(Comando.class));
			verify(transactionResponseService).store(any(TransactionSpResponse.class));

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

	private List<InterfazAprovisionamiento> createInterfaceStub(String... lista) {
		List<InterfazAprovisionamiento> interfaces = new ArrayList<InterfazAprovisionamiento>();

		for (int i = 0; i < lista.length; i++) {
			InterfazAprovisionamiento ia = new InterfazAprovisionamiento();
			ia.setInterfaceCode(lista[i]);
			interfaces.add(ia);
		}

		return interfaces;
	}

}