package com.ec.tvcable.switchaprov;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.exception.AprovisionamientoException;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;
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
			transactionResponse.setXMLResponse(aprovisionamientoResponseToXMLString(response));
			transactionResponseService.store(transactionResponse);

			return response;
		} catch (Exception e) {
			e.printStackTrace();
			BodyResponse bodyResponse = new BodyResponse();
			bodyResponse.setResponseCode(1);
			bodyResponse.setResponseMessage(String.format("Error general de ejecucion: %s %s", e.getClass(),
					e.getMessage()));
			response.setBodyResponse(bodyResponse);
			return response;
		}

	}

	private BodyResponse generateBodyResponse(List<DeviceResponse> deviceResponses) {
		BodyResponse bodyResponse = new BodyResponse();

		bodyResponse.setProcessId(Integer.parseInt(aprovisionamientoType.getBodyRequest().getProcessId()));

		int failCount = 0;
		StringBuilder sb = new StringBuilder();
		for (DeviceResponse dr : deviceResponses) {
			bodyResponse.getDevices().add(dr);
			if (dr.getErrorCode() > 0) {
				sb.append(String.format("Device: %s %s", dr.getSerialNumber(), dr.getErrorMessage()));
				for (Interface inter : dr.getInterfaces()) {
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
		for (Device device : aprovisionamientoType.getBodyRequest().getDevice()) {

			Operation operation = new Operation(device.getSystem(), device.getActivityType());

			List<InterfaceInvocationResponse> iiResponses;

			try {
				iiResponses = invokeInterfaces(interfazResolver.resolveInterfaces(operation), device);
				deviceResponses.add(generateDeviceResponse(device, iiResponses));
			} catch (AprovisionamientoException e) {
				deviceResponses.add(generateDeviceErrorResponse(e, device));
			}


		}

		return deviceResponses;
	}

	private DeviceResponse generateDeviceErrorResponse(AprovisionamientoException e, Device device) {
		DeviceResponse dr = new DeviceResponse();
		dr.setDeviceId(Integer.parseInt(device.getDeviceId()));
		dr.setErrorCode(1);
		dr.setSerialNumber(device.getSerialNumber());
		dr.setErrorMessage(e.getMessage());
		return dr;
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

	private List<InterfaceInvocationResponse> invokeInterfaces(List<InterfazAprovisionamiento> interfaces, Device device) {

		ComandoInterfaces comandoInterfaces = new ComandoInterfaces(aprovisionamientoType, interfaces, device);

		if ("INT".equals(aprovisionamientoType.getHeaderRequest().getTarget())) {
			return interfaz600.invokeInterfaces(comandoInterfaces);
		}
		if ("TV".equals(aprovisionamientoType.getHeaderRequest().getTarget())) {
			return tvInterfaceService.invokeInterfaces(comandoInterfaces);
		}
		throw new RuntimeException(String.format("No existe implementacion para el TARGET: %s", aprovisionamientoType
				.getHeaderRequest().getTarget()));
	}

	private String aprovisionamientoResponseToXMLString(AprovisionamientoResponse ar) {
		try {
			JAXBContext context = JAXBContext.newInstance(AprovisionamientoResponse.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter sw = new StringWriter();
			marshaller.marshal(ar, sw);
			return sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

}