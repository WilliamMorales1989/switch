/**
 * 
 */
package com.ec.tvcable.switch_aprov;

import java.util.List;

import com.ec.tvcable.switch_aprov.servicio.ems.EMS_Type;

/**
 * @author pablo
 *
 */
public class ComandoEmsInterfaces {
	
	public ComandoEmsInterfaces(EMS_Type comandoEms, List<String> interfaces) {
		super();
		this.comandoEms = comandoEms;
		this.interfaces = interfaces;
	}

	private EMS_Type comandoEms;
	
	private List<String> interfaces;

	public EMS_Type getComandoEms() {
		return comandoEms;
	}

	public void setComandoEms(EMS_Type comandoEms) {
		this.comandoEms = comandoEms;
	}

	public List<String> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<String> interfaces) {
		this.interfaces = interfaces;
	}

}
