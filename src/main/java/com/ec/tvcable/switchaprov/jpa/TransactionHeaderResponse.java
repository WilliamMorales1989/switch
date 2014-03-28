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

import com.ec.tvcable.switchaprov.Constants;
import com.ec.tvcable.switchaprov.JaxbConverter;
import com.ec.tvcable.switchaprov.service.aprov.DeviceResponse;

/**
 * @author pablo
 * 
 */
@Entity
@Table(name = "transaction_header_response")
public class TransactionHeaderResponse {

	@Id
	@SequenceGenerator(name = "TRANSACTION_HEAD_RESPONSE_SEQ", sequenceName = "TRANSACTION_HEAD_RESPONSE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_HEAD_RESPONSE_SEQ")
	private Long id;

	@Column(name="process_id")
	private Integer processId;

	@Column(name = "request_date")
	private Date requestDate;

	@Column(name = "xml_request")
	@Lob
	private String XMLRequest;

	@Column(name = "error_code")
	private int errorCode = 0;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(referencedColumnName = "id", name = "header_Id")
	private List<TransactionSpResponse> transactioSpResponses;

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

	public String getXMLRequest() {
		return XMLRequest;
	}

	public void setXMLRequest(String xMLRequest) {
		XMLRequest = xMLRequest;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public List<TransactionSpResponse> getTransactioSpResponses() {
		return transactioSpResponses;
	}

	public void setTransactioSpResponses(List<TransactionSpResponse> deviceResponses) {
		this.transactioSpResponses = deviceResponses;
	}

	private void addDeviceResponseIfNotDataError(DeviceResponse deviceResponse) {
		System.out.println(deviceResponse.getErrorCode() + " - " + Constants.DEVICE_DATA_FAIL_CODE);
		this.transactioSpResponses = new ArrayList<TransactionSpResponse>();
		if (deviceResponse.getErrorCode() != Constants.DEVICE_DATA_FAIL_CODE) {
			System.out.println("son diferentes");
			TransactionSpResponse transactionResponse = new TransactionSpResponse();
			transactionResponse.setErrorCode(deviceResponse.getErrorCode());
			transactionResponse.setXMLResponse(JaxbConverter.deviceResponseToXMLString(deviceResponse));
			transactionResponse.setDeviceId(deviceResponse.getDeviceId());
			transactionResponse
					.setProcessId(this.processId);
			transactioSpResponses.add(transactionResponse);
		}
	}

	public void addDeviceResponses(List<DeviceResponse> deviceResponses) {
		System.out.println("devices: " + deviceResponses.size());
		for (DeviceResponse deviceResponse : deviceResponses) {
			addDeviceResponseIfNotDataError(deviceResponse);
		}
	}

}
