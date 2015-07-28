package com.ec.tvcable.switchaprov.service.tvconax;

public class RespuestaConax {

	private String xml;
	private String estado;
	private String ErrorNo;
	private String ErrorMessage;
	
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getErrorNo() {
		return ErrorNo;
	}
	public void setErrorNo(String errorNo) {
		ErrorNo = errorNo;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	
	
}
