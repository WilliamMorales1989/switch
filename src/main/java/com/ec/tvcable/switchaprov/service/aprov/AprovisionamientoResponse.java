
package com.ec.tvcable.switchaprov.service.aprov;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HeaderResponse" type="{http://www.example.org/Aprovisionamiento/}HeaderResponse"/>
 *         &lt;element name="BodyResponse" type="{http://www.example.org/Aprovisionamiento/}BodyResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "headerResponse",
    "bodyResponse"
})
@XmlRootElement(name = "AprovisionamientoResponse")
public class AprovisionamientoResponse {

    @XmlElement(name = "HeaderResponse", required = true)
    protected HeaderResponse headerResponse;
    @XmlElement(name = "BodyResponse", required = true)
    protected BodyResponse bodyResponse;
    
    
    public String getXMLStringResponce() {
		try {
			JAXBContext context = JAXBContext.newInstance(AprovisionamientoResponse.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter sw = new StringWriter();
			marshaller.marshal(this, sw);
			return sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

    /**
     * Gets the value of the headerResponse property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderResponse }
     *     
     */
    public HeaderResponse getHeaderResponse() {
        return headerResponse;
    }

    /**
     * Sets the value of the headerResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderResponse }
     *     
     */
    public void setHeaderResponse(HeaderResponse value) {
        this.headerResponse = value;
    }

    /**
     * Gets the value of the bodyResponse property.
     * 
     * @return
     *     possible object is
     *     {@link BodyResponse }
     *     
     */
    public BodyResponse getBodyResponse() {
        return bodyResponse;
    }

    /**
     * Sets the value of the bodyResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BodyResponse }
     *     
     */
    public void setBodyResponse(BodyResponse value) {
        this.bodyResponse = value;
    }

}
