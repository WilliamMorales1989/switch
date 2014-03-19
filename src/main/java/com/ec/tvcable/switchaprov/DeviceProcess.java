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
	
	private String deviceId;
	private String processId;
	
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
}
