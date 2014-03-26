/**
 * 
 */
package com.ec.tvcable.switchaprov.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "process_id")
	private Integer processId;

	@Column(name = "request_date")
	private Date requestDate;

	@Column(name = "xml_response")
	private String XMLResponse;

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

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

}
