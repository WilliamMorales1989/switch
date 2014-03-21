package com.ec.tvcable.switchaprov;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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

	@Override
	public AprovisionamientoResponse Aprovisionamiento(Aprovisionamiento_Type parameters) {

		this.aprovisionamientoType = parameters;

		AprovisionamientoResponse response = new AprovisionamientoResponse();
		try {
			List<DeviceResponse> deviceResponses = processDevices();

			
			response.setBodyResponse(generateBodyResponse(deviceResponses));
			
			
			
			TransactionSpResponse transactionResponse = new TransactionSpResponse();
			// transactionResponse.setDetMensaje(response.getErrorMessage());
			transactionResponse.setXMLResponse(response.getXMLStringResponce());
			transactionResponseService.store(transactionResponse);
			// response.setErrorMessage(responseMessage.toString());

			return response;
		} catch (RuntimeException e) {
			e.printStackTrace();
			BodyResponse bodyResponse = new BodyResponse();
			bodyResponse.setResponseCode(100);
			bodyResponse.setResponseMessage(e.getMessage());
			response.setBodyResponse(bodyResponse);
			System.out.println(bodyResponse.getResponseMessage());
			return response;
		}

	}

	private BodyResponse generateBodyResponse(List<DeviceResponse> deviceResponses) {
		BodyResponse bodyResponse = new BodyResponse();

		bodyResponse.setProcessId(Integer.parseInt(aprovisionamientoType.getBodyRequest().getProcessId()));

		int failCount = 0;
		StringBuilder sb = new StringBuilder();
		for (DeviceResponse deviceResponse : deviceResponses) {
			bodyResponse.getDevices().add(deviceResponse);
			if (deviceResponse.getErrorCode() > 0) {
				sb.append(String.format("Device: %s ", deviceResponse.getSerialNumber()));
				for (Interface inter : deviceResponse.getInterfaces()) {
					if (inter.getErrorCode() > 0) {
						failCount++;
						sb.append(inter.getErrorMessage());
					}
				}
			}
		}

		bodyResponse.setResponseCode(failCount);
		bodyResponse.setResponseMessage(sb.toString());
		return bodyResponse;
	}

	private List<DeviceResponse> processDevices() {

		List<DeviceResponse> deviceResponses = new ArrayList<DeviceResponse>();
		for (Device device : aprovisionamientoType.getBodyRequest().getDevices()) {

			Operation operation = new Operation(device.getSystem(), device.getActivityType());

			List<InterfaceInvocationResponse> iiResponses = invokeInterfaces(interfazResolver
					.resolveInterfaces(operation), device);

			deviceResponses.add(generateDeviceResponse(device, iiResponses));
		}

		return deviceResponses;
	}

	private DeviceResponse generateDeviceResponse(Device device, List<InterfaceInvocationResponse> responses) {
		DeviceResponse deviceResponse = new DeviceResponse();
		deviceResponse.setDeviceId(Integer.parseInt(device.getDeviceId()));
		deviceResponse.setSerialNumber(device.getSerialNumber());
		for (InterfaceInvocationResponse iir : responses) {
			Interface inter = new Interface();
			inter.setErrorCode(iir.getCodError());
			inter.setErrorMessage(iir.getDetailMessage());
			inter.setInterfazId(iir.getInterfazInt());
			deviceResponse.getInterfaces().add(inter);
			if (iir.getCodError() > 0) {
				deviceResponse.setErrorCode(iir.getCodError());
			}
		}

		return deviceResponse;
	}

	private List<InterfaceInvocationResponse> invokeInterfaces(List<String> interfaces, Device device) {

		ComandoInterfaces comandoInterfaces = new ComandoInterfaces(aprovisionamientoType, interfaces, device);

		if ("INT".equals(aprovisionamientoType.getHeaderRequest().getTarget())) {
			return interfaz600.invokeInterfaces(comandoInterfaces);
		}
		if ("TV".equals(aprovisionamientoType.getHeaderRequest().getTarget())) {
			return tvInterfaceService.invokeInterfaces(comandoInterfaces);
		}
		return null;
	}

}