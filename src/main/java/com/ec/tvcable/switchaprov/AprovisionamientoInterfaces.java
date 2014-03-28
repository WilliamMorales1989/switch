/**
 * 
 */
package com.ec.tvcable.switchaprov;

import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.aprov.Device;

/**
 * @author pablo
 *
 */
public class AprovisionamientoInterfaces {
	
	public AprovisionamientoInterfaces(Aprovisionamiento_Type aprovisionamientoType, Device device) {
		super();
		this.aprovisionamientoType = aprovisionamientoType;
		this.device = device;
	}

	private Aprovisionamiento_Type aprovisionamientoType;
	
	private Device device;

	public Aprovisionamiento_Type getAprovisionamientoType() {
		return aprovisionamientoType;
	}

	public void setAprovisionamientoType(Aprovisionamiento_Type aprovisionamientoType) {
		this.aprovisionamientoType = aprovisionamientoType;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
