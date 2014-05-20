package com.ec.tvcable.switchaprov;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

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
	private IntrawayInterfaceService intrawayInterfaceService;

	@Reference
	@Inject
	private TransactionSpResponseService transactionResponseService;

	private Aprovisionamiento_Type aprovisionamientoRequest;

	private List<DeviceResponse> deviceResponses;

	@Override
	public AprovisionamientoResponse Aprovisionamiento(Aprovisionamiento_Type parameters) {

		this.aprovisionamientoRequest = parameters;

		Date initialDate = new Date();
		
		processDevices();

		AprovisionamientoResponse response = new AprovisionamientoResponse();
		
		BodyResponse bodyResponse = buildBodyResponse();
		
		response.setBodyResponse(bodyResponse);

		saveResponse(bodyResponse, initialDate);

		return response;

	}

	private void saveResponse(BodyResponse bodyResponse, Date initialDate) {
		TransactionHeaderResponse headerResponse = new TransactionHeaderResponse();
		headerResponse.setProcessId(bodyResponse.getProcessId());
		headerResponse.setResponseDate(new Date());
		headerResponse.setRequestDate(initialDate);
		headerResponse.setXMLRequest(JaxbConverter.objectToXMLString((aprovisionamientoRequest)));
		headerResponse.setResponseCode(bodyResponse.getResponseCode());
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

			//DeviceProcessor deviceProcessor = new DeviceProcessor(tvInterfaceService);
			DeviceProcessor deviceProcessor = new DeviceProcessor(tvInterfaceService,intrawayInterfaceService);

			deviceResponses.add(deviceProcessor.processDevice(device, aprovisionamientoRequest));

		}

	}

}