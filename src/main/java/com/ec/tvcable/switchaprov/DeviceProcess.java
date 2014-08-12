/**
 * 
 */
package com.ec.tvcable.switchaprov;

/**
 * @author pablo
 * 
 */
public class DeviceProcess {

	public DeviceProcess(String deviceId, String processId) {
		super();
		this.deviceId = deviceId;
		this.processId = processId;
	}
	
	public DeviceProcess(String deviceId, String processId, String interfaceId ) {
		super();
		this.deviceId = deviceId;
		this.processId = processId;
		this.interfaceId = interfaceId;
	}
	
	private String deviceId;
	private String processId;
	private String interfaceId;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getInterfaceId() {
		return interfaceId;
	}
	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}
}
