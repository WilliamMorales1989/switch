/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.util.List;

import com.ec.tvcable.switchaprov.exception.AprovisionamientoException;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.aprov.Device;
import com.ec.tvcable.switchaprov.service.aprov.DeviceResponse;
import com.ec.tvcable.switchaprov.service.aprov.Interface;

/**
 * @author pablo
 * 
 */
public class DeviceProcessor {

	private static final int FAIL_DEVICE_CODE = 1;

	private static int SUCCESS_MEDIATOR_CODE = 1;

	private TvInterfaceService tvInterfaceService;
	private InterfazResolver interfazResolver;

	public DeviceProcessor(TvInterfaceService tvInterfaceService, InterfazResolver interfazResolver) {
		super();
		this.tvInterfaceService = tvInterfaceService;
		this.interfazResolver = interfazResolver;
	}

	public DeviceResponse processDevice(Device device, Aprovisionamiento_Type aprovisionamientoType) {

		Operation operation = new Operation(device.getSystem(), device.getActivityType());
		try {
			List<InterfazAprovisionamiento> interfaces = interfazResolver.resolveInterfaces(operation);
			AprovisionamientoInterfaces aprovisionamientoInterfaces = new AprovisionamientoInterfaces(
					aprovisionamientoType, interfaces, device);

			List<InterfaceInvocationResponse> responses = invokeInterfaces(aprovisionamientoInterfaces);

			return generateDeviceResponse(device, responses);

		} catch (AprovisionamientoException e) {
			return generateDeviceExceptionResponse(e, device);
		}
	}

	private List<InterfaceInvocationResponse> invokeInterfaces(AprovisionamientoInterfaces aprovisionamientoInterfaces)
			throws AprovisionamientoException {
		switch (aprovisionamientoInterfaces.getDevice().getSystem()) {
		case "INT":
			return null;
		case "TV":
			return tvInterfaceService.invokeInterfaces(aprovisionamientoInterfaces);
		default:
			throw new AprovisionamientoException(String.format("No existe implementacion para el SYSTEM: %s",
					aprovisionamientoInterfaces.getDevice().getSystem()));
		}
	}

	private DeviceResponse generateDeviceResponse(Device device, List<InterfaceInvocationResponse> responses) {
		DeviceResponse dr = new DeviceResponse();
		dr.setDeviceId(Integer.parseInt(device.getDeviceId()));
		dr.setSerialNumber(device.getSerialNumber());
		for (InterfaceInvocationResponse iir : responses) {
			Interface inter = new Interface();
			inter.setErrorCode(iir.getCodError());
			inter.setErrorMessage(iir.getDetailMessage());
			inter.setInterfazId(iir.getInterfazInt());
			dr.getInterfaces().add(inter);
			if (iir.getCodError() != SUCCESS_MEDIATOR_CODE) {
				dr.setErrorCode(FAIL_DEVICE_CODE);
			}
		}

		return dr;
	}

	private DeviceResponse generateDeviceExceptionResponse(Exception e, Device device) {
		DeviceResponse dr = new DeviceResponse();
		dr.setDeviceId(Integer.parseInt(device.getDeviceId()));
		dr.setSerialNumber(device.getSerialNumber());
		dr.setErrorCode(FAIL_DEVICE_CODE);
		dr.setErrorMessage(e.getMessage());
		return dr;
	}

}
