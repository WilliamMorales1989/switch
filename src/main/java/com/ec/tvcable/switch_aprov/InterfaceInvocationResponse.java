/**
 * 
 */
package com.ec.tvcable.switch_aprov;

/**
 * @author pablo
 *
 */
public class InterfaceInvocationResponse {

	private String interfaz;
	
	private int codError;
	
	private String detMensaje;
	
	public int getCodError() {
		return codError;
	}
	
	public void setCodError(int codError) {
		this.codError = codError;
	}
	
	public String getDetMensaje() {
		return detMensaje;
	}
	
	public void setDetMensaje(String detMensaje) {
		this.detMensaje = detMensaje;
	}
	
	public String getInterfaz() {
		return interfaz;
	}
	
	public void setInterfaz(String interfaz) {
		this.interfaz = interfaz;
	}

	public String getDetailMessage() {
		if (interfaz == null){
			return getDetMensaje();
		}
		return String.format("Interfaz %s: %s |", interfaz, detMensaje);
	}
	
}