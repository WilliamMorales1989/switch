/**
 * 
 */
package com.ec.tvcable.switchaprov.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pablo
 *
 */
@Entity
@Table(name="transaction_sp_response")
//@SequenceGenerator(sequenceName="TRANSACTION_SP_RESPONSE_SEQ", name = "GENERATOR")
public class TransactionSpResponse {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENERATOR")
	private Long id;
	
	@Column(name="device_id")
	private Integer deviceId;
	
	@Column(name="interface")
	private Integer interfaceCode;
	
	@Column(name="request_id")
	private Integer requestId;
	
	@Column(name="request_date")
	private Date requestDate;
	
	@Column(name="CodError")
	private Integer codError;
	
	@Column(name="detMensaje")
	private String detMensaje;
	
	private String datosExtrasTVP;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(Integer interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Integer getCodError() {
		return codError;
	}

	public void setCodError(Integer codError) {
		this.codError = codError;
	}

	public String getDetMensaje() {
		return detMensaje;
	}

	public void setDetMensaje(String detMensaje) {
		this.detMensaje = detMensaje;
	}

	public String getDatosExtrasTYP() {
		return datosExtrasTVP;
	}

	public void setDatosExtrasTYP(String datosExtrasTYP) {
		this.datosExtrasTVP = datosExtrasTYP;
	}

}
