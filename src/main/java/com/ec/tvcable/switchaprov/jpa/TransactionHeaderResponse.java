/**
 * 
 */
package com.ec.tvcable.switchaprov.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ec.tvcable.switchaprov.Constants;
import com.ec.tvcable.switchaprov.JaxbConverter;
import com.ec.tvcable.switchaprov.service.aprov.DeviceResponse;

/**
 * @author pablo
 * 
 */
@Entity
@Table(name = "TRANSACTION_SP_RESPONSE_HEADER")
public class TransactionHeaderResponse {

	@Id
	@SequenceGenerator(name = "TRANSACTION_RESPONSE_H_SEQ", sequenceName = "TRANSACTION_RESPONSE_H_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_RESPONSE_H_SEQ")
	private Integer id;

	@Column(name="process_id")
	private Integer processId;
	
	@Column(name = "xml_request")
	@Lob
	private String XMLRequest;
	
	@Column(name = "request_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;
	
	@Column(name = "response_code")
	private int responseCode = 0;

	@Column(name = "response_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date responseDate;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(referencedColumnName = "id", name = "header_Id")
	private List<TransactionSpResponse> transactioSpResponses;

	private void addDeviceResponseIfNotDataError(DeviceResponse deviceResponse) {
		if (deviceResponse.getErrorCode() != Constants.DEVICE_DATA_FAIL_CODE) {
			TransactionSpResponse transactionResponse = new TransactionSpResponse();
			transactionResponse.setResponseCode(deviceResponse.getErrorCode());
			transactionResponse.setXMLResponse(JaxbConverter.objectToXMLString(deviceResponse));
			transactionResponse.setDeviceId(deviceResponse.getDeviceId());
			transactionResponse
					.setProcessId(this.id);
			transactioSpResponses.add(transactionResponse);
		}
	}

	public void addDeviceResponses(List<DeviceResponse> deviceResponses) {
		this.transactioSpResponses = new ArrayList<TransactionSpResponse>();
		for (DeviceResponse deviceResponse : deviceResponses) {
			addDeviceResponseIfNotDataError(deviceResponse);
		}
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getXMLRequest() {
		return XMLRequest;
	}

	public void setXMLRequest(String xMLRequest) {
		XMLRequest = xMLRequest;
	}

	public void setResponseCode(int errorCode) {
		this.responseCode = errorCode;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public List<TransactionSpResponse> getTransactioSpResponses() {
		return transactioSpResponses;
	}

	public void setTransactioSpResponses(List<TransactionSpResponse> deviceResponses) {
		this.transactioSpResponses = deviceResponses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

}
