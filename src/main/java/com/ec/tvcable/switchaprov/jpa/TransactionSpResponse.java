/**
 * 
 */
package com.ec.tvcable.switchaprov.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author pablo
 * 
 */
@Entity
@Table(name = "transaction_sp_response")
public class TransactionSpResponse {

	@Id
	@SequenceGenerator(name = "TRANSACTION_SP_RESPONSE_SEQ", sequenceName = "TRANSACTION_SP_RESPONSE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_SP_RESPONSE_SEQ")
	private Long id;

	@Column(name = "header_id")
	private Integer headerId;

	@Column(name = "process_id")
	private Integer processId;

	@Column(name = "device_id")
	private Integer deviceId;

	@Column(name = "xml_response")
	@Lob
	private String XMLResponse;

	@Column(name = "response_code")
	private int responseCode = 0;

	public String getXMLResponse() {
		return XMLResponse;
	}

	public void setXMLResponse(String xMLResponse) {
		XMLResponse = xMLResponse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer requestId) {
		this.processId = requestId;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public void setResponseCode(int errorCode) {
		this.responseCode = errorCode;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public Integer getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Integer headerId) {
		this.headerId = headerId;
	}

}
