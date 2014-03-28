/**
 * 
 */
package com.ec.tvcable.switchaprov;

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
		if (interfaz == null || "0".equals(interfaz)) {
			return detMensaje;
		}
		return String.format("(I: %s) %s", interfaz, detMensaje);
	}

	public int getInterfazInt() {
		return interfaz == null ? 0 : Integer.parseInt(interfaz);
	}

	public boolean getFailedExecution() {
		return getCodError() != Constants.SUCCESS_MEDIATOR_CODE;
	}

}