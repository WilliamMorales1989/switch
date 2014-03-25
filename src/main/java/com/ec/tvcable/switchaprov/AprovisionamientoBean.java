package com.ec.tvcable.switchaprov;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.jpa.TransactionSpResponse;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento;
import com.ec.tvcable.switchaprov.service.aprov.AprovisionamientoResponse;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.aprov.BodyResponse;
import com.ec.tvcable.switchaprov.service.aprov.Device;
import com.ec.tvcable.switchaprov.service.aprov.DeviceResponse;
import com.ec.tvcable.switchaprov.service.aprov.Interface;

@Service(Aprovisionamiento.class)
public class AprovisionamientoBean implements Aprovisionamiento {

	private static final int FAIL_DEVICE_CODE = 1;

	private static int SUCCESS_MEDIATOR_CODE = 1;

	private static int FAIL_PROCESS_CODE = 1;

	@Inject
	@Reference
	private TvInterfaceService tvInterfaceService;

	@Inject
	@Reference
	private IntrawayInterfaceService interfaz600;

	@Inject
	@Reference
	private InterfazResolver interfazResolver;

	@Reference
	@Inject
	private TransactionSpResponseService transactionResponseService;

	private Aprovisionamiento_Type aprovisionamientoType;

	private AprovisionamientoResponse response;

	private List<DeviceResponse> deviceResponses;

	@Override
	public AprovisionamientoResponse Aprovisionamiento(Aprovisionamiento_Type parameters) {

		this.aprovisionamientoType = parameters;

		response = new AprovisionamientoResponse();

		processDevices();

		response.setBodyResponse(buildBodyResponse());

		saveDbResponse(parameters);

		return response;

	}

	private void saveDbResponse(Aprovisionamiento_Type parameters) {
		TransactionSpResponse transactionResponse = new TransactionSpResponse();
		transactionResponse.setXMLResponse(aprovisionamientoResponseToXMLString());
		transactionResponse.setRequestDate(new Date());
		transactionResponse.setRequestId(Integer.parseInt(parameters.getBodyRequest().getProcessId()));
		transactionResponseService.store(transactionResponse);
	}

	private BodyResponse buildBodyResponse() {
		BodyResponse bodyResponse = new BodyResponse();

		bodyResponse.setProcessId(Integer.parseInt(aprovisionamientoType.getBodyRequest().getProcessId()));

		StringBuilder sb = new StringBuilder();
		for (DeviceResponse dr : deviceResponses) {
			bodyResponse.getDevices().add(dr);
			if (errorInDeviceResponse(dr)) {
				bodyResponse.setResponseCode(FAIL_PROCESS_CODE);
				
				sb.append(String.format("Device: %s %s", dr.getSerialNumber(), dr.getErrorMessage()));
				sb.append(buildInterfaceDetail(dr));
				sb.append(" | ");
			}
		}
		bodyResponse.setResponseMessage(removeLastPipeFrom(sb));
		return bodyResponse;
	}

	private String buildInterfaceDetail(DeviceResponse dr) {
		StringBuilder sb = new StringBuilder(60);
		for (Interface inter : dr.getInterfaces()) {
			if (errorInInterfaceProcess(inter)) {
				sb.append(inter.getErrorMessage());
			}
		}
		return sb.toString();
	}

	private boolean errorInInterfaceProcess(Interface inter) {
		return inter.getErrorCode() != SUCCESS_MEDIATOR_CODE;
	}

	private boolean errorInDeviceResponse(DeviceResponse dr) {
		return dr.getErrorCode() == FAIL_DEVICE_CODE;
	}

	private String removeLastPipeFrom(StringBuilder sb) {
		if (sb.length() > 3)
			return sb.substring(0, sb.length() - 3);
		else
			return sb.toString();
	}

	private void processDevices() {

		deviceResponses = new ArrayList<DeviceResponse>();

		for (Device device : aprovisionamientoType.getBodyRequest().getDevice()) {

			DeviceProcessor deviceProcessor = new DeviceProcessor(tvInterfaceService, interfazResolver);

			deviceResponses.add(deviceProcessor.processDevice(device, aprovisionamientoType));

		}

	}

	private String aprovisionamientoResponseToXMLString() {
		try {
			JAXBContext context = JAXBContext.newInstance(AprovisionamientoResponse.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter sw = new StringWriter();
			marshaller.marshal(response, sw);
			return sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

}