/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.ec.tvcable.switchaprov.exception.ExceptionProcessor;
import com.ec.tvcable.switchaprov.service.aprov.DeviceResponse;

/**
 * @author pablo
 *
 */
public class JaxbConverter {
	
	private static Logger logger = Logger.getLogger(AprovisionamientoBean.class);

	public static String deviceResponseToXMLString(DeviceResponse deviceResponse) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(DeviceResponse.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter sw = new StringWriter();
			marshaller.marshal(deviceResponse, sw);
			return sw.toString();
		} catch (JAXBException e) {
			ExceptionProcessor ep = new ExceptionProcessor(e);
			logger.error(e);
			return ep.buildDetailMessage();
		}
	}



}
