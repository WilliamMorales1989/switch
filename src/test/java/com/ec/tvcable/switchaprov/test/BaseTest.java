package com.ec.tvcable.switchaprov.test;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.ec.tvcable.switchaprov.jpa.TransactionSpTvPagada;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.aprov.BodyRequest;
import com.ec.tvcable.switchaprov.service.aprov.Device;
import com.ec.tvcable.switchaprov.service.aprov.HeaderRequest;

public class BaseTest {

	private final String TEST_RESOURCE_PATH = "src/test/resources/";
	
	protected Document loadDocumentXML(String path) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db.parse(getClass().getClassLoader().getResourceAsStream(path));
	}

	protected String loadStringXML(String path) throws Exception {
		String content = new Scanner(new File(TEST_RESOURCE_PATH + path)).useDelimiter("\\Z")
				.next();
		return content;
	}

	protected TransactionSpTvPagada createDatosTvPagada() {
		TransactionSpTvPagada transactionSpTvPagada = new TransactionSpTvPagada();
		transactionSpTvPagada.setId(1l);
		transactionSpTvPagada.setDeviceId(1l);
		transactionSpTvPagada.setIdEmpresa(1l);
		transactionSpTvPagada.setNegocio("1");
		transactionSpTvPagada.setSecuencia(1l);
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

	protected Aprovisionamiento_Type createAprovisionamientotype() {
		Aprovisionamiento_Type type = new Aprovisionamiento_Type();

		HeaderRequest header = new HeaderRequest();
		header.setTarget("TV");

		BodyRequest body = new BodyRequest();
		body.setProcessId("1");

		type.setBodyRequest(body);
		type.setHeaderRequest(header);

		return type;
	}

	protected void addDeviceToRequest(Aprovisionamiento_Type request, String id, String activity, String serialNumber) {

		Device device = new Device();
		device.setDeviceId(id);
		device.setActivityType(activity);
		device.setSerialNumber(serialNumber);
		
		request.getBodyRequest().getDevices().add(device);

	}

	
}
