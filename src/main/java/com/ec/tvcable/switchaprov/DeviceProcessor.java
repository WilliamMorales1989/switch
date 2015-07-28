/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.util.List;

import org.mockito.internal.matchers.Not;

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
			e.printStackTrace();
			return generateDeviceExceptionResponse(e, device, Constants.DEVICE_FAIL_CODE);
		}
	}

	private List<InterfaceInvocationResponse> invokeInterfaces(AprovisionamientoInterfaces aprovisionamientoInterfaces)
			throws AprovisionamientoException, DataQueryException {
		switch (aprovisionamientoInterfaces.getDevice().getSystem()) {
		case "INT":
			System.out.println("INT");
			return intrawayInterfaceService.invokeInterfaces(aprovisionamientoInterfaces);
		case "TELF":
			System.out.println("TELF");
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
		try {
		for (InterfaceInvocationResponse iir : responses) {
			Interface inter = new Interface();
			
			String msg_error = "(I: 822) Codigo de Producto y/o Producto Padre ya Exite y/o se encuentra en otro Cliente. SRV_INTEGRITY_ERROR. Los+parametros+ingresados+no+son+validos";
	
			/*System.out.println("william: "+iir.getDetailMessage().compareTo(msg_error));
			System.out.println("william: "+iir.getDetailMessage().compareTo(msg_error+"1"));*/

			if (iir.getDetailMessage().compareTo(msg_error)==0){
				inter.setErrorCode(1);
				iir.setCodError(1);
				inter.setErrorMessage("(I: 822) Proceso Realizado con Éxito.Operation Success");
				inter.setInterfazId(iir.getInterfazInt());
				dr.getInterfaces().add(inter);
			}else{
				
			inter.setErrorCode(iir.getCodError());
			inter.setErrorMessage(iir.getDetailMessage());
			inter.setInterfazId(iir.getInterfazInt());
			dr.getInterfaces().add(inter);
			
			}
			
			if (device.getController().equals("Conax"))
			{
				if (inter.getErrorCode() == 0){
					dr.setErrorCode(iir.getCodError());
				}else{
					dr.setErrorCode(1);
					
				}
				
			}else{
				boolean flag1 = iir.isFailedExecution();
				if (flag1 == true) {
					dr.setErrorCode(Constants.DEVICE_FAIL_CODE);
				}
			}
		}

		return dr;
		}catch(Exception e) {
			System.out.println("Eror conax: " + e);
			return dr;
			}
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
