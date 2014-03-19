/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.util.List;

import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.aprov.Device;

/**
 * @author pablo
 *
 */
public class ComandoInterfaces {
	
	public ComandoInterfaces(Aprovisionamiento_Type aprovisionamientoType, List<String> interfaces, Device device) {
		super();
		this.aprovisionamientoType = aprovisionamientoType;
		this.interfaces = interfaces;
		this.device = device;
	}

	private Aprovisionamiento_Type aprovisionamientoType;
	
	private List<String> interfaces;

	private Device device;

	public Aprovisionamiento_Type getAprovisionamientoType() {
		return aprovisionamientoType;
	}

	public void setAprovisionamientoType(Aprovisionamiento_Type aprovisionamientoType) {
		this.aprovisionamientoType = aprovisionamientoType;
	}

	public List<String> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<String> interfaces) {
		this.interfaces = interfaces;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
