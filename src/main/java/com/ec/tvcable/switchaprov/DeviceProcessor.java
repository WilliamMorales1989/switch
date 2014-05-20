/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.util.List;

import com.ec.tvcable.switchaprov.exception.AprovisionamientoException;
import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.exception.ExceptionProcessor;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.aprov.Device;
import com.ec.tvcable.switchaprov.service.aprov.DeviceResponse;
import com.ec.tvcable.switchaprov.service.aprov.Interface;

/**
 * @author pablo
 * 
 */
public class DeviceProcessor {

	private TvInterfaceService tvInterfaceService;
	private IntrawayInterfaceService intrawayInterfaceService;

	public DeviceProcessor(TvInterfaceService tvInterfaceService) {
		super();
		this.tvInterfaceService = tvInterfaceService;
	}
	
	public DeviceProcessor(IntrawayInterfaceService intrawayInterfaceService) {
		super();
		this.intrawayInterfaceService = intrawayInterfaceService;
	}
	
	public DeviceProcessor(TvInterfaceService tvInterfaceService, IntrawayInterfaceService intrawayInterfaceService) {
		super();
		this.tvInterfaceService = tvInterfaceService;
		this.intrawayInterfaceService = intrawayInterfaceService;
	}

	public DeviceResponse processDevice(Device device, Aprovisionamiento_Type aprovisionamientoType) {

		try {

			AprovisionamientoInterfaces aprovisionamientoInterfaces = new AprovisionamientoInterfaces(
					aprovisionamientoType, device);

			List<InterfaceInvocationResponse> responses = invokeInterfaces(aprovisionamientoInterfaces);

			return generateDeviceResponse(device, responses);

		} catch (DataQueryException e) {
			return generateDeviceExceptionResponse(e, device, Constants.DEVICE_DATA_FAIL_CODE);
		} catch (Exception e) {
			return generateDeviceExceptionResponse(e, device, Constants.DEVICE_FAIL_CODE);
		}
	}

	private List<InterfaceInvocationResponse> invokeInterfaces(AprovisionamientoInterfaces aprovisionamientoInterfaces)
			throws AprovisionamientoException, DataQueryException {
		switch (aprovisionamientoInterfaces.getDevice().getSystem()) {
		case "INT":
			System.out.println("INT");
			return intrawayInterfaceService.invokeInterfaces(aprovisionamientoInterfaces);
		case "TV":
			System.out.println("TV");
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
			if (iir.isFailedExecution()) {
				dr.setErrorCode(Constants.DEVICE_FAIL_CODE);
			}
		}

		return dr;
	}

	private DeviceResponse generateDeviceExceptionResponse(Exception e, Device device, int deviceFaildCode) {
		DeviceResponse dr = new DeviceResponse();
		dr.setDeviceId(Integer.parseInt(device.getDeviceId()));
		dr.setSerialNumber(device.getSerialNumber());
		dr.setErrorCode(deviceFaildCode);
		ExceptionProcessor ep=new ExceptionProcessor(e);
		dr.setErrorMessage(ep.buildDetailMessage());
		return dr;
	}

}
