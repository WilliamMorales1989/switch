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

import com.ec.tvcable.switchaprov.jpa.TransactionHeaderResponse;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento;
import com.ec.tvcable.switchaprov.service.aprov.AprovisionamientoResponse;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.aprov.BodyResponse;
import com.ec.tvcable.switchaprov.service.aprov.Device;
import com.ec.tvcable.switchaprov.service.aprov.DeviceResponse;
import com.ec.tvcable.switchaprov.service.aprov.Interface;

@Service(Aprovisionamiento.class)
public class AprovisionamientoBean implements Aprovisionamiento {

	@Inject
	@Reference
	private TvInterfaceService tvInterfaceService;

	@Inject
	@Reference
	private IntrawayInterfaceService interfaz600;

	@Reference
	@Inject
	private TransactionSpResponseService transactionResponseService;

	private Aprovisionamiento_Type aprovisionamientoRequest;

	private AprovisionamientoResponse response;

	private List<DeviceResponse> deviceResponses;

	@Override
	public AprovisionamientoResponse Aprovisionamiento(Aprovisionamiento_Type parameters) {

		this.aprovisionamientoRequest = parameters;

		response = new AprovisionamientoResponse();
		
		processDevices();

		saveResponse();

		response.setBodyResponse(buildBodyResponse());

		return response;

	}

	private void saveResponse() {
		TransactionHeaderResponse headerResponse = new TransactionHeaderResponse();
		headerResponse.setProcessId(Integer.parseInt(aprovisionamientoRequest.getBodyRequest().getProcessId()));
		headerResponse.setRequestDate(new Date());
		headerResponse.setXMLRequest(aprovisionamientoResponseToXMLString());
		
		headerResponse.addDeviceResponses(deviceResponses);

		transactionResponseService.saveHeader(headerResponse);
	}

	private BodyResponse buildBodyResponse() {
		BodyResponse bodyResponse = new BodyResponse();

		bodyResponse.setProcessId(Integer.parseInt(aprovisionamientoRequest.getBodyRequest().getProcessId()));

		StringBuilder sb = new StringBuilder();
		for (DeviceResponse dr : deviceResponses) {
			bodyResponse.getDevices().add(dr);
			if (errorInDeviceResponse(dr)) {
				bodyResponse.setResponseCode(Constants.PROCESS_FAIL_CODE);

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
		return inter.getErrorCode() != Constants.SUCCESS_MEDIATOR_CODE;
	}

	private boolean errorInDeviceResponse(DeviceResponse dr) {
		return dr.getErrorCode() == Constants.DEVICE_FAIL_CODE || dr.getErrorCode() == Constants.DEVICE_DATA_FAIL_CODE;
	}

	private String removeLastPipeFrom(StringBuilder sb) {
		if (sb.length() > 3)
			return sb.substring(0, sb.length() - 3);
		else
			return sb.toString();
	}

	private void processDevices() {

		deviceResponses = new ArrayList<DeviceResponse>();

		for (Device device : aprovisionamientoRequest.getBodyRequest().getDevice()) {

			DeviceProcessor deviceProcessor = new DeviceProcessor(tvInterfaceService);

			deviceResponses.add(deviceProcessor.processDevice(device, aprovisionamientoRequest));

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